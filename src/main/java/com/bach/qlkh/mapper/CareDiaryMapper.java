package com.bach.qlkh.mapper;

import com.bach.qlkh.dto.CareDiaryDto;
import com.bach.qlkh.model.CareDiary;

public class CareDiaryMapper {

    public static CareDiaryDto mapToCareDiaryDto(CareDiary careDiary) {

        return CareDiaryDto.builder()
                .id(careDiary.getId())
                .content(careDiary.getContent())
                .title(careDiary.getTitle())
                .state(careDiary.getState())
                .customer(null)
                .build();

    }

    public static CareDiary mapToCareDiary(CareDiaryDto careDiary) {

        return CareDiary.builder()
                .id(careDiary.getId())
                .content(careDiary.getContent())
                .title(careDiary.getTitle())
                .state(careDiary.getState())
                .customer(null)
                .build();

    }

    public static void updateCareDiaryFromCareDiaryDto(CareDiaryDto careDiaryDto, CareDiary careDiary){

        careDiary.setTitle(careDiaryDto.getTitle());
        careDiary.setContent(careDiaryDto.getContent());

    }

}
