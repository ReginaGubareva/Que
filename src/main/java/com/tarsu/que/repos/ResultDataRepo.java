package com.tarsu.que.repos;

import com.tarsu.que.domain.ResultData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultDataRepo extends JpaRepository<ResultData, Long> {

    List<ResultData> findAllByResult_ResultId(Long resultId);
    List<ResultData> findAllByQuestionId(Long questionId);
}
