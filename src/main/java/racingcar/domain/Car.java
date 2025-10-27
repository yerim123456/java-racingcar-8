package racingcar.domain;

import static racingcar.error.ErrorMessages.CAR_NAME_SIZE_INVALID;

public class Car {
    private final String name;
    private final int location;

    private static final int MAX_NAME_LENGTH = 5;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.location = 0;
    }

    private Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_SIZE_INVALID.getMessage());
        }
    }

    public Car move(boolean isMovable) {
        if (isMovable) {
            return new Car(name, location + 1);
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
