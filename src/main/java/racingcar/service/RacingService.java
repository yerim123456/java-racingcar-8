package racingcar.service;

import static racingcar.error.ErrorMessages.CAR_NAME_INPUT_IS_EMPTY;
import static racingcar.error.ErrorMessages.ROUND_COUNT_INPUT_IS_NOT_PLUS;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MovePolicy;
import racingcar.domain.WinnerCalculator;

public class RacingService {
    public static final String NAME_SEPARATOR = ",";
    private Cars cars;
    private final MovePolicy movePolicy;

    public RacingService(MovePolicy movePolicy) {
        this.movePolicy = movePolicy;
    }

    public void initCars(String namesInput) {
        List<Car> cars = Arrays.stream(namesInput.split(NAME_SEPARATOR))
                .map(String::trim)
                .map(Car::new)
                .toList();

        this.cars = new Cars(cars);
    }

    public static void validateInputNamesIsNotNullAndEmpty(String namesInput) {
        if (namesInput == null || namesInput.isBlank()) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_IS_EMPTY.getMessage());
        }
    }

    public static void validateInputRoundCountIsPlus(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException(ROUND_COUNT_INPUT_IS_NOT_PLUS.getMessage());
        }
    }

    public Cars playRound() {
        cars = cars.moveAll(movePolicy);
        return cars;
    }

    public List<String> getWinners() {
        return WinnerCalculator.calculateWinners(cars);
    }
}
