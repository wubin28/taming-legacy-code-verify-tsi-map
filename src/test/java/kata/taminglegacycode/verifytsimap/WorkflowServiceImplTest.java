package kata.taminglegacycode.verifytsimap;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    //xFliSts_in_wTsiMap_should_not_be_null
    //xFliSts_in_wTsiMap_should_be_01
    //xTsiSts_in_wTsiMap_should_be_01
    //xTskCod_in_wTsiMap_should_be_in_wBasTypLst
    //xOprUsr_in_wTsiMap_should_be_equal_to_pUsrOam

}
