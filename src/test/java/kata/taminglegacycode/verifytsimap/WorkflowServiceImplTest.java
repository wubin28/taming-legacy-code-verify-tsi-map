package kata.taminglegacycode.verifytsimap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.*;

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
public class WorkflowServiceImplTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void wTsiMap_should_not_be_null() throws FrameworkException {
        thrown.expect(FrameworkException.class);
        thrown.expectMessage("wTsiMap should not be null");

        List<String> wBasTypLst = new ArrayList<>();
        WorkflowServiceImpl workflowServiceImpl = new WorkflowServiceImpl(wBasTypLst);
        Map<String, Object> pTsiInfMap = new HashMap<>();
        String pUsrOam = "";
        Map<String, Object> wTsiMap = null;

        workflowServiceImpl.checkTsiInf(pTsiInfMap, pUsrOam, wTsiMap);
    }

    @Test
    public void xFliSts_in_wTsiMap_should_not_be_null() throws FrameworkException {
        thrown.expect(FrameworkException.class);
        thrown.expectMessage("xFliSts in wTsiMap should not be null");

        List<String> wBasTypLst = new ArrayList<>();
        WorkflowServiceImpl workflowServiceImpl = new WorkflowServiceImpl(wBasTypLst);
        Map<String, Object> pTsiInfMap = new HashMap<>();
        String pUsrOam = "";
        Map<String, Object> wTsiMap = new HashMap<String, Object>() {{
            put("xFliSts", null);
        }};

        workflowServiceImpl.checkTsiInf(pTsiInfMap, pUsrOam, wTsiMap);
    }

    @Test
    public void xFliSts_in_wTsiMap_should_be_01() throws FrameworkException {
        thrown.expect(FrameworkException.class);
        thrown.expectMessage("xFliSts in wTsiMap should be 01");

        List<String> wBasTypLst = new ArrayList<>();
        WorkflowServiceImpl workflowServiceImpl = new WorkflowServiceImpl(wBasTypLst);
        Map<String, Object> pTsiInfMap = new HashMap<>();
        String pUsrOam = "";
        Map<String, Object> wTsiMap = new HashMap<String, Object>() {{
            put("xFliSts", "02");
        }};

        workflowServiceImpl.checkTsiInf(pTsiInfMap, pUsrOam, wTsiMap);
    }

    @Test
    public void xTsiSts_in_wTsiMap_should_be_01() throws FrameworkException {
        thrown.expect(FrameworkException.class);
        thrown.expectMessage("xTsiSts in wTsiMap should be 01");

        List<String> wBasTypLst = new ArrayList<>();
        WorkflowServiceImpl workflowServiceImpl = new WorkflowServiceImpl(wBasTypLst);
        Map<String, Object> pTsiInfMap = new HashMap<>();
        String pUsrOam = "";
        Map<String, Object> wTsiMap = new HashMap<String, Object>() {{
            put("xFliSts", "01");
            put("xTsiSts", "02");
        }};

        workflowServiceImpl.checkTsiInf(pTsiInfMap, pUsrOam, wTsiMap);
    }

    @Test
    public void xTskCod_in_wTsiMap_should_not_be_in_wBasTypLst() throws FrameworkException {
        thrown.expect(FrameworkException.class);
        thrown.expectMessage("xTskCod in wTsiMap should not be in wBasTypLst");

        List<String> wBasTypLst = Arrays.asList("03");
        WorkflowServiceImpl workflowServiceImpl = new WorkflowServiceImpl(wBasTypLst);
        Map<String, Object> pTsiInfMap = new HashMap<>();
        String pUsrOam = "";
        Map<String, Object> wTsiMap = new HashMap<String, Object>() {{
            put("xFliSts", "01");
            put("xTsiSts", "01");
            put("xTskCod", "03");
        }};

        workflowServiceImpl.checkTsiInf(pTsiInfMap, pUsrOam, wTsiMap);
    }

    @Test
    public void xOprUsr_in_wTsiMap_should_be_equal_to_pUsrOam() throws FrameworkException {
        thrown.expect(FrameworkException.class);
        thrown.expectMessage("xOprUsr in wTsiMap should be equal to pUsrOam");

        List<String> wBasTypLst = Arrays.asList("01");
        WorkflowServiceImpl workflowServiceImpl = new WorkflowServiceImpl(wBasTypLst);
        Map<String, Object> pTsiInfMap = new HashMap<>();
        Map<String, Object> wTsiMap = new HashMap<String, Object>() {{
            put("xFliSts", "01");
            put("xTsiSts", "01");
            put("xTskCod", "03");
            put("xOprUsr", "123456");
        }};

        workflowServiceImpl.checkTsiInf(pTsiInfMap, "1234567", wTsiMap);
    }
}
