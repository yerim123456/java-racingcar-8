package racingcar.view;

import static racingcar.view.ViewMessages.OUTPUT_VIEW_FINAL_RESULT_WINNER;
import static racingcar.view.ViewMessages.OUTPUT_VIEW_FINAL_RESULT_WINNER_SEPARATOR;
import static racingcar.view.ViewMessages.OUTPUT_VIEW_ROUND_RESULT_MOVE_SYMBOL;
import static racingcar.view.ViewMessages.OUTPUT_VIEW_ROUND_RESULT_TITLE;

import java.util.List;
import racingcar.dto.CarsDto;

public class OutputView {
    public void printRoundResultTitle() {
        System.out.println(OUTPUT_VIEW_ROUND_RESULT_TITLE.getMessage());
    }

    public void printRoundResult(CarsDto cars) {
        cars.carDtoList().forEach(car -> System.out.println(car.name() + " : "
                + OUTPUT_VIEW_ROUND_RESULT_MOVE_SYMBOL.getMessage().repeat(car.location())));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(OUTPUT_VIEW_FINAL_RESULT_WINNER.getMessage() +
                String.join(OUTPUT_VIEW_FINAL_RESULT_WINNER_SEPARATOR.getMessage(), winners));
    }
}
