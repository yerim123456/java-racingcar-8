package racingcar.domain;

import static racingcar.error.ErrorMessages.CARS_ARE_EMPTY;
import static racingcar.error.ErrorMessages.CARS_NAME_DUPLICATED;
import static racingcar.error.ErrorMessages.CARS_SIZE_INVALID;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        validateListNotNullAndEmpty(cars);
        validateInputNameIsMoreThanOne(cars);
        validateUniqueNames(cars);
        this.cars = cars;
    }

    private static void validateListNotNullAndEmpty(List<Car> cars) {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(CARS_ARE_EMPTY.getMessage());
        }
    }

    private static void validateInputNameIsMoreThanOne(List<Car> cars) {
        if (cars.size() < 2) {
            throw new IllegalArgumentException(CARS_SIZE_INVALID.getMessage());
        }
    }

    private static void validateUniqueNames(List<Car> cars) {
        long distinctCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (distinctCount != cars.size()) {
            throw new IllegalArgumentException(CARS_NAME_DUPLICATED.getMessage());
        }
    }

    public Cars moveAll(MovePolicy movePolicy) {
        List<Car> moved = this.cars.stream()
                .map(car -> car.move(movePolicy.canMove()))
                .collect(Collectors.toList());
        return new Cars(moved);
    }

    public List<Car> getCars() {
        return cars;
    }
}
