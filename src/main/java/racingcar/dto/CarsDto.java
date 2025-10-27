package racingcar.dto;

import java.util.List;

public record CarsDto(List<CarDto> carDtoList) {
    public CarsDto {
        // 불변 리스트로 복사해서 저장
        carDtoList = List.copyOf(carDtoList);
    }

    
}


