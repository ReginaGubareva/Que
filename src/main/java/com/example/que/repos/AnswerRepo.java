package com.example.que.repos;

import com.example.que.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepo extends JpaRepository<Answer, Long> {
    List<Answer> findAllByQuestionId(Long questionId);
    String findAnswerById(Long answerId);
}
