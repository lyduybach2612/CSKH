package com.bach.qlkh.repository;

import com.bach.qlkh.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
