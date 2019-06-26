package com.example.que.domain;

import javax.persistence.*;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "result_data")
public class ResultData {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long dataId;

    private Long questionId;

    private String answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Result result;

    public ResultData() {}

    public ResultData(Long questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
