package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Cars;

@DisplayName("RacingService 단위 테스트")
class RacingServiceTest {

    @Test
    @DisplayName("성공: 자동차 이름 입력 시 trim 적용")
    void 성공_자동차_이름_입력후_trim_적용() {
        RacingService service = new RacingService(() -> true);
        service.initCars(" pobi , jun ");

        List<String> carNames = service.playRound().getCars()
                .stream()
                .map(Car::getName)
                .toList();

        assertThat(carNames).containsExactly("pobi", "jun");

    }

    @Test
    @DisplayName("성공: 양의 정수 경주 차수 설정 가능")
    void 성공_양의_정수_경주_차수_설정_가능() {
        assertThatCode(() -> RacingService.validateInputRoundCountIsPlus(3))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("성공: 여러 라운드 후 위치 누적")
    void 성공_여러_라운드_후_위치_누적() {
        RacingService service = new RacingService(() -> true);
        service.initCars("pobi,jun");

        service.playRound();
        Cars result = service.playRound();

        assertThat(result.getCars()).allMatch(car -> car.getLocation() == 2);
    }

    @Test
    @DisplayName("성공: 우승자 리스트 반환 및 입력 순서 유지")
    void 성공_우승자_리스트_반환_및_입력_순서_유지() {
        RacingService service = new RacingService(() -> true);
        service.initCars("pobi,jun");
        service.playRound();
        List<String> winners = service.getWinners();

        assertThat(winners).containsExactly("pobi", "jun");
    }

    @ParameterizedTest(name = "입력값 \"{0}\"이면 IllegalArgumentException 발생")
    @NullAndEmptySource
    @DisplayName("실패: 자동차 이름 입력 null 또는 공백이면 예외 발생")
    void 실패_자동차_이름_입력_null_또는_공백(String input) {
        assertThatThrownBy(() -> RacingService.validateInputNamesIsNotNullAndEmpty(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @ParameterizedTest(name = "입력값 \"{0}\"이면 IllegalArgumentException 발생")
    @ValueSource(strings = {"0", "-1", "abc"})
    @DisplayName("실패: 경주 차수가 0, 음수, 숫자 아님이면 예외 발생")
    void 실패_경주_차수_잘못된_입력(String input) {
        assertThatThrownBy(() -> {
            int roundCount = Integer.parseInt(input); // 숫자 변환
            RacingService.validateInputRoundCountIsPlus(roundCount);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
