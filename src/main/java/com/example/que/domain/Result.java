package com.example.que.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long resultId;

    private Long queId;

    private Long userId;

    @OneToMany(mappedBy = "result", cascade = CascadeType.ALL)
    private List<ResultData> resultList;

    public Result() {}

    public Result(Long queId, Long userId, List<ResultData> resultList) {
        this.queId = queId;
        this.userId = userId;
        this.resultList = resultList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getQueId() {
        return queId;
    }

    public void setQueId(Long queId) {
        this.queId = queId;
    }

    public List<ResultData> getResultList() {
        return resultList;
    }

    public void setAnswers(List<ResultData> resultList) {
        this.resultList = resultList;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }
}
