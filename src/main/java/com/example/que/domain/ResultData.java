package com.example.que.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.*;

@Entity
@Table(name = "result_data")
public class ResultData {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long dataId;

    private Long questionId;

    @NotBlank(message = "Please fill the answer")
    @Length(max = 2048, message = "Too long(more than 2kB)")
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
