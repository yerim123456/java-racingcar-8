package racingcar.domain;

import static racingcar.error.ErrorMessages.CARS_ARE_EMPTY;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerCalculator {

    public static List<String> calculateWinners(Cars cars) {
        int maxLocation = cars.getCars().stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(CARS_ARE_EMPTY.getMessage()));

        return cars.getCars().stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
