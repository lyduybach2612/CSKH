package com.bach.qlkh.repository;

import com.bach.qlkh.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Long> {
    Manager findByManagerName(String name);
}
