package com.bach.qlkh.service;

import com.bach.qlkh.dto.CareDiaryDto;

import java.util.List;

public interface CareDiaryService {
    List<CareDiaryDto> getAllCareDiaries();

    void createCareDiary(CareDiaryDto careDiary);

    void activeCareDiary(Long careDiaryId);

    CareDiaryDto findCareDiary(Long careDiaryId);

    void updateCareDiary(Long careDiaryId, CareDiaryDto careDiary);
}
