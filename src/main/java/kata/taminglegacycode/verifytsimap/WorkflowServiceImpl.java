package kata.taminglegacycode.verifytsimap;

import java.util.List;
import java.util.Map;

public class WorkflowServiceImpl {
    private static final String QRY_TSI_INF = "qry_tsi_inf";
    private List wBasTypLst;

    /**
     * Data for testing:
     * pTsiInfMap:
     * ("xStrBbk","9341"),("xTsiTyp","UH023")
     *
     * wTsiMap:
     * ("xFliSts","01"),("xTsiSts","01"),("xTskCod","03"),("xOprUsr","123456")
     *
     * wBasTypLst:
     * ("01","02","03")
     *
     */
    private Map<String, Object> checkTsiInf(Map<String, Object> pTsiInfMap, String pUsrOam) throws FrameworkException {

        Map<String, Object> wTsiMap = getPersistenceFactory().selectOne(QRY_TSI_INF, pTsiInfMap);
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
            throw new FrameworkException("**************");
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
