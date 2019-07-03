package com.example.que.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the answer")
    @Length(max = 2048, message = "Too long(more than 2kB)")
    private String answer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Question question;

    public Answer(){}

    public Answer(String answer){
        this.answer = answer;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Question getQuestion() { return question; }

    public void setQuestion(Question question) { this.question = question; }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
