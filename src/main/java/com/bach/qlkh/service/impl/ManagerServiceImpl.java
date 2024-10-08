package com.bach.qlkh.service.impl;

import com.bach.qlkh.repository.ManagerRepository;
import com.bach.qlkh.service.ManagerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    ManagerRepository managerRepository;

}
