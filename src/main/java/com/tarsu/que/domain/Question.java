package com.tarsu.que.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the question")
    @Length(max = 2048, message = "Too long(more than 2kB)")
    private String question;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "que_id", referencedColumnName = "id")
    private Que que;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answersList = new ArrayList<>();

    public Question(){}

    public Question(String question, Answer... answers) {
        this.question = question;
        this.answersList = Stream.of(answers).collect(Collectors.toList());
        this.answersList.forEach(x->x.setQuestion(this));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Que getQue() { return que; }

    public void setQue(Que que) { this.que = que; }
    public List<Answer> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Answer> answersList) {
        this.answersList = answersList;
    }

    @Override
    public String toString() {
        return "Question{" +
                " 'question='" + question + '\'' +
                ", answersList=" + answersList +
                '}';
    }
}
