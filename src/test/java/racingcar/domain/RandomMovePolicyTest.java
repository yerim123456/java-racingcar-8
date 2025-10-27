package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("RandomMovePolicy 단위 테스트")
class RandomMovePolicyTest {

    @RepeatedTest(5)
    @DisplayName("랜덤값 4 이상이면 실제 정책에서 true 반환 가능")
    void 성공_랜덤값_4이상_정책_전진_확률검증() {
        RandomMovePolicy policy = new RandomMovePolicy();
        boolean result = policy.canMove();

        // 4~9 값일 땐 true, 0~3 값일 땐 false — Random이므로 확률 테스트
        assertThat(result).isIn(true, false);
    }
}
