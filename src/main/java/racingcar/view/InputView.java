package racingcar.view;

import static racingcar.error.ErrorMessages.ROUND_COUNT_INPUT_MUST_VALID_NUMBER;
import static racingcar.view.ViewMessages.INPUT_VIEW_QUESTION_CAR_NAMES;
import static racingcar.view.ViewMessages.INPUT_VIEW_QUESTION_ROUND_COUNT;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String readCarNames() {
        System.out.println(INPUT_VIEW_QUESTION_CAR_NAMES);
        return Console.readLine();
    }

    public int readRoundCount() {
        System.out.println(INPUT_VIEW_QUESTION_ROUND_COUNT);
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUND_COUNT_INPUT_MUST_VALID_NUMBER.getMessage(), e);
        }
    }

}
