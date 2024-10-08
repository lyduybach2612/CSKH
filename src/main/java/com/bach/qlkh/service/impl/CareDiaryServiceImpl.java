package com.bach.qlkh.service.impl;

import com.bach.qlkh.repository.CareDiaryRepository;
import com.bach.qlkh.service.CareDiaryService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CareDiaryServiceImpl implements CareDiaryService {

    CareDiaryRepository careDiaryRepository;

}
