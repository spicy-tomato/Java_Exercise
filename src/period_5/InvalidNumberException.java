package period_5;

public class InvalidNumberException extends Exception {
    String message;

    public InvalidNumberException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "Invalid number: " + message + ".";
    }
}
