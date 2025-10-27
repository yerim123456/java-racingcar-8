package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WinnerCalculator 단위 테스트")
class WinnerCalculatorTest {

    @Test
    @DisplayName("성공: 최대 이동 거리 계산 및 우승자 필터링")
    void 성공_최대_이동_거리_계산_및_우승자_필터링() {
        Car car1 = new Car("pobi").move(true).move(true);
        Car car2 = new Car("jun").move(true);
        Cars cars = new Cars(List.of(car1, car2));

        List<String> winners = WinnerCalculator.calculateWinners(cars);

        assertThat(winners).containsExactly("pobi");
    }

    @Test
    @DisplayName(" 실패: 자동차 리스트 비어있으면 예외 발생")
    void 실패_자동차_리스트_비어있으면_예외() {
        assertThatThrownBy(() -> WinnerCalculator.calculateWinners(new Cars(List.of())))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
