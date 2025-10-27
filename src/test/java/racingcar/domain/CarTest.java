package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Car 클래스 단위 테스트")
class CarTest {

    @Test
    @DisplayName("성공: 이름 길이 1~5자면 생성 가능")
    void 성공_이름_길이_1_5자_허용_생성_가능() {
        assertThatCode(() -> new Car("pobi"))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("성공: 이동 조건 충족 시 위치 1 증가")
    void 성공_이동_조건_충족시_위치_증가() {
        Car car = new Car("pobi");
        Car moved = car.move(true);
        assertThat(moved.getLocation()).isEqualTo(car.getLocation() + 1);
    }

    @Test
    @DisplayName("성공: 이동 조건 미충족 시 위치 유지")
    void 성공_이동_조건_미충족시_위치_유지() {
        Car car = new Car("pobi");
        Car stayed = car.move(false);
        assertThat(stayed.getLocation()).isEqualTo(car.getLocation());
    }

    @ParameterizedTest(name = "이름이 \"{0}\"이면 IllegalArgumentException 발생")
    @ValueSource(strings = {"", " ", "abcdef"})
    @DisplayName("실패: 이름이 공백이거나 5자 초과면 예외 발생")
    void 실패_잘못된_이름_입력(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
