package zubcic.travel.travelapplication.exception;

public class ExistingUsernameException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;

    public ExistingUsernameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
