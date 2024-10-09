package com.bach.qlkh.repository;

import com.bach.qlkh.model.CareDiary;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CareDiaryRepository extends JpaRepository<CareDiary, Long> {

    List<CareDiary> findAllByOrderByStateAsc();

}
