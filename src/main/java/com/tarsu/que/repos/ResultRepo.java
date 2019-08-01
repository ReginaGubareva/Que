package com.tarsu.que.repos;

import com.tarsu.que.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepo extends JpaRepository<Result, Long> {

    List<Result> findAllByQueId(Long queId);
}
