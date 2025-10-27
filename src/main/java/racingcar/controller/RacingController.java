package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.dto.CarsDto;
import racingcar.mapper.CarsMapper;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView, RacingService racingService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racingService = racingService;
    }

    public void run() {
        // 입력 값 받아오기 (경주할 자동차 이름, 경주 차수)
        String namesInput = inputView.readCarNames();
        int roundCount = inputView.readRoundCount();

        // 입력값 유효성 검증
        RacingService.validateInputNamesIsNotNullAndEmpty(namesInput);
        RacingService.validateInputRoundCountIsPlus(roundCount);

        // 자동차 이름 값 검증 및 Cars 객체 생성
        racingService.initCars(namesInput);

        // 경주 차수에 따른 결과 출력
        outputView.printRoundResultTitle();
        for (int i = 0; i < roundCount; i++) {
            // 변경된 cars 받아 dto로 변환
            Cars cars = racingService.playRound();
            CarsDto carsDto = CarsMapper.toDto(cars);

            // 경주 라운드 실행 결과 출력
            outputView.printRoundResult(carsDto);
        }

        // 경주 승자 출력
        outputView.printWinners(racingService.getWinners());
    }
}
