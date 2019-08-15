package kata.taminglegacycode.verifytsimap;

public class FrameworkException extends Exception {
    private final String message;

    public FrameworkException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
