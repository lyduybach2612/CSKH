package com.bach.qlkh.service.impl;

import com.bach.qlkh.dto.CareDiaryDto;
import com.bach.qlkh.mapper.CareDiaryMapper;
import com.bach.qlkh.model.CareDiary;
import com.bach.qlkh.repository.CareDiaryRepository;
import com.bach.qlkh.service.CareDiaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CareDiaryServiceImpl implements CareDiaryService {

    CareDiaryRepository careDiaryRepository;

    @Override
    public List<CareDiaryDto> getAllCareDiaries() {

        List<CareDiary> careDiaries = careDiaryRepository.findAllByOrderByStateAsc();
        return careDiaries.stream().map(CareDiaryMapper::mapToCareDiaryDto).toList();

    }

    @Override
    public void createCareDiary(CareDiaryDto careDiaryDto) {

        careDiaryDto.setState(false);
        CareDiary careDiary = CareDiaryMapper.mapToCareDiary(careDiaryDto);
        careDiaryRepository.save(careDiary);

    }

    @Override
    public void activeCareDiary(Long careDiaryId) {

        CareDiary careDiary = careDiaryRepository.findById(careDiaryId).get();
        careDiary.setState(true);
        careDiaryRepository.save(careDiary);

    }

    @Override
    public CareDiaryDto findCareDiary(Long careDiaryId) {

        CareDiary careDiary = careDiaryRepository.findById(careDiaryId).get();
        return CareDiaryMapper.mapToCareDiaryDto(careDiary);

    }

    @Override
    public void updateCareDiary(Long careDiaryId, CareDiaryDto careDiaryDto) {

        CareDiary careDiary = careDiaryRepository.findById(careDiaryId).get();
        CareDiaryMapper.updateCareDiaryFromCareDiaryDto(careDiaryDto, careDiary);
        careDiary.setId(careDiaryId);
        careDiaryRepository.save(careDiary);

    }

}
