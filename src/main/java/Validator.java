public class Validator {
    private void defaultValidate(final String string) {
        if (string == null)
            throw new IllegalArgumentException(ErrorCode.EMPTY_INPUT.getMessage());
        if (!string.matches("[A-Za-z]*")) {
            throw new IllegalArgumentException(ErrorCode.WRONG_INPUT.getMessage());
        }
    }

    public void validateWeights(final String string) {
        if (string == null)
            throw new IllegalArgumentException(ErrorCode.EMPTY_INPUT.getMessage());
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_WEIGHTS.getMessage());
        }
    }

    public void validateValues(final String values) {
        defaultValidate(values);
        if (values.length() != Parameters.BOARD_SIZE)
            throw new IllegalArgumentException(ErrorCode.WRONG_MAP.getMessage());
    }

    public void validateLocation(final String location) {
        defaultValidate(location);
        if(!Parameters.LOCATIONS.contains(location)) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_LOCATION.getMessage());
        }
    }

    public void validateRace(final String race) {
        defaultValidate(race);
        if(!Parameters.RACES.contains(race)) {
            throw new IllegalArgumentException(ErrorCode.ILLEGAL_RACE.getMessage());
        }
    }
}
