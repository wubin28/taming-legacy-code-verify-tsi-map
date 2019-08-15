package kata.taminglegacycode.verifytsimap;

public class StringUtil {
    public static boolean isEmpty(String xOprUsr) {
        if (xOprUsr == null) {
            return true;
        }
        if ("".equals(xOprUsr)) {
            return true;
        }
        return false;
    }
}
