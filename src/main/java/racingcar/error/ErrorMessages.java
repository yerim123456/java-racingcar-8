package racingcar.error;


public enum ErrorMessages {

    ROUND_COUNT_INPUT_IS_NOT_PLUS("경주 차수는 양수여야 합니다."),
    ROUND_COUNT_INPUT_MUST_VALID_NUMBER("경주 차수는 숫자여야 합니다."),
    CAR_NAME_INPUT_IS_EMPTY("자동차 이름이 입력되지 않았습니다."),
    CAR_NAME_SIZE_INVALID("자동차 이름은 1~5자여야 합니다."),
    CARS_ARE_EMPTY("자동차 목록이 비어있습니다."),
    CARS_SIZE_INVALID("자동차 이름은 두 개 이상이어야 합니다."),
    CARS_NAME_DUPLICATED("자동차 이름이 중복됩니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
