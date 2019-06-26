package com.example.que.domain;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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
