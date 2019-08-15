package kata.taminglegacycode.verifytsimap;

import java.util.List;
import java.util.Map;

public class WorkflowServiceImpl {
    protected static final String QRY_TSI_INF = "qry_tsi_inf";
    private List<String> wBasTypLst;

    public WorkflowServiceImpl(List wBasTypLst) {
        this.wBasTypLst = wBasTypLst;
    }

    private Map<String, Object> checkTsiInf(Map<String, Object> pTsiInfMap, String pUsrOam) throws FrameworkException {
        return checkTsiInf(pTsiInfMap, pUsrOam, getPersistenceFactory());
    }

    protected Map<String, Object> checkTsiInf(Map<String, Object> pTsiInfMap, String pUsrOam, PersistenceFactory persistenceFactory) throws FrameworkException {

        Map<String, Object> wTsiMap = persistenceFactory.selectOne(QRY_TSI_INF, pTsiInfMap);

        if (null == wTsiMap) {
            throw new FrameworkException("wTsiMap should not be null");
        }

        if (null == wTsiMap.get("xFliSts")) {
            throw new FrameworkException("xFliSts in wTsiMap should not be null");
        }

        if (!"01".equals((String) wTsiMap.get("xFliSts"))) {
            throw new FrameworkException("xFliSts in wTsiMap should be 01");
        }

        if (!"01".equals((String) wTsiMap.get("xTsiSts"))) {
            throw new FrameworkException("xTsiSts in wTsiMap should be 01");
        }

        if (wBasTypLst.contains((String) wTsiMap.get("xTskCod"))) {
            throw new FrameworkException("xTskCod in wTsiMap should not be in wBasTypLst");
        }

        if (!StringUtil.isEmpty((String) wTsiMap.get("xOprUsr")) && !pUsrOam.equals((String) wTsiMap.get("xOprUsr"))) {
            throw new FrameworkException("xOprUsr in wTsiMap should be equal to pUsrOam");
        }

        PUBAUT_BrnAutCheck.checkTsiTyp(this, pUsrOam, (String) pTsiInfMap.get("xStrBbk"), (String) pTsiInfMap.get("xTsiTyp"));

        return wTsiMap;
    }

    private PersistenceFactory getPersistenceFactory() {
        return new PersistenceFactory();
    }
}
