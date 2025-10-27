package racingcar.mapper;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.dto.CarDto;
import racingcar.dto.CarsDto;

public class CarsMapper {
    public static CarsDto toDto(Cars cars) {
        List<CarDto> carDtoList = cars.getCars().stream()
                .map(car -> new CarDto(car.getName(), car.getLocation()))
                .toList();
        return new CarsDto(carDtoList);
    }
}
