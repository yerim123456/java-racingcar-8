package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RandomMovePolicy implements MovePolicy {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final int MIN_MOVE_TRIGGER = 4;

    @Override
    public boolean canMove() {
        return RandomGenerator.generate(MIN, MAX) >= MIN_MOVE_TRIGGER;
    }
}
