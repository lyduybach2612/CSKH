package com.bach.qlkh.service;

import com.bach.qlkh.model.Manager;

public interface ManagerService {
    Manager findByUsername(String username);
}
