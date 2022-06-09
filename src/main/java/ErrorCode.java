public enum ErrorCode {
    EMPTY_INPUT("Empty enter"),
    WRONG_INPUT("Wrong input"),
    ILLEGAL_RULES("Illegal rules"),
    ILLEGAL_RACE("Illegal race"),
    ILLEGAL_LOCATION("Illegal location"),
    ILLEGAL_WEIGHTS("Illegal weights"),
    WRONG_MAP("Wrong map");

    private final String message;

    ErrorCode(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
