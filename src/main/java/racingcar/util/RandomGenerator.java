package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomGenerator {

    public static int generate(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
