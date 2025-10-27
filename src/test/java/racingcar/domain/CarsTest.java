package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Cars 클래스 단위 테스트")
class CarsTest {

    static Cars cars;

    @BeforeAll
    static void setup() {
        cars = new Cars(List.of(new Car("a"), new Car("b")));
    }

    @Test
    @DisplayName("성공: 여러 자동차 동시에 이동 가능")
    void 성공_여러_자동차_동시에_이동_가능() {
        MovePolicy movePolicy = () -> true;
        Cars moved = cars.moveAll(movePolicy);
        assertThat(moved.getCars()).allMatch(car -> car.getLocation() == 1);
    }

    @Test
    @DisplayName("성공: 라운드 진행 시 이동 거리 누적")
    void 성공_라운드_진행시_이동_거리_누적() {
        Cars cars = new Cars(List.of(new Car("a"), new Car("b")));
        MovePolicy movePolicy = () -> true;

        cars = cars.moveAll(movePolicy);
        cars = cars.moveAll(movePolicy);

        assertThat(cars.getCars()).allMatch(car -> car.getLocation() == 2);
    }

    @Test
    @DisplayName("실패: 자동차 리스트 비어있으면 예외 발생")
    void 실패_자동차_리스트_비어있으면_예외() {
        assertThatThrownBy(() -> new Cars(List.of()))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실패: 자동차 1대만 입력하면 예외 발생")
    void 실패_자동차_1대만_입력하면_예외() {
        assertThatThrownBy(() -> new Cars(List.of(new Car("solo"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("실패: 자동차 이름 중복이면 예외 발생")
    void 실패_자동차_이름_중복이면_예외() {
        assertThatThrownBy(() -> new Cars(List.of(new Car("a"), new Car("a"))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
