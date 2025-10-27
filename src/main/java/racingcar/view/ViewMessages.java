package racingcar.view;


public enum ViewMessages {

    INPUT_VIEW_QUESTION_CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_VIEW_QUESTION_ROUND_COUNT("시도할 횟수는 몇 회인가요?"),
    OUTPUT_VIEW_ROUND_RESULT_TITLE("\n실행 결과"),
    OUTPUT_VIEW_ROUND_RESULT_MOVE_SYMBOL("-"),
    OUTPUT_VIEW_FINAL_RESULT_WINNER("최종 우승자 : "),
    OUTPUT_VIEW_FINAL_RESULT_WINNER_SEPARATOR(", ");

    private final String message;

    ViewMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
