package com.example.que.domain;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "results")
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resultId;

    private HashMap<Long, String> questionResult;

    public Results(){}

    public Results(HashMap<Long, String> questionResult) {
        this.questionResult = questionResult;
    }

    public void setQuestionResult(HashMap<Long, String> questionResult) {
        this.questionResult = questionResult;
    }

    public Map<Long, String> getQuestionResult() {
        return questionResult;
    }

    @Override
    public String toString() {
        return "Results{" +
                "questionResult=" + questionResult.keySet() +
                " " + questionResult.values() +
                '}';
    }
}
