package com.tarsu.que.domain;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name = "que")
public class Que {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the name of your Que")
    @Length(max = 2048, message = "Too long(more than 2kB)")
    private String queName;

    @NotBlank(message = "Please fill the Que desription")
    @Length(max = 2048, message = "Too long(more than 2kB)")
    private String queDescription;

    @OneToMany(mappedBy = "que", cascade = CascadeType.ALL)
    private List<Question> questionsList;

//    @OneToOne
//    private User user;

    public Que(){}

    public Que(String queName, String queDescription, Question... questionList) {
        this.queName = queName;
        this.queDescription = queDescription;
        this.questionsList = Stream.of(questionList).collect(Collectors.toList());
        this.questionsList.forEach(x->x.setQue(this));
    }

    public int getQuestionsCount(){
        int size = questionsList.size();
        return size != 0 ? size : 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueName() {
        return queName;
    }

    public void setQueName(String queName) {
        this.queName = queName;
    }

    public String getQueDescription() {
        return queDescription;
    }

    public void setQueDescription(String queDescription) {
        this.queDescription = queDescription;
    }

    public List<Question> getQuestionsList() {
        return questionsList;
    }

    public void setQuestionsList(List<Question> questionsList) {
        this.questionsList = questionsList;
    }

//    public User getUser() { return user; }
//
//    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Que{" +
                "queName='" + queName + '\'' +
                ", queDescription='" + queDescription + '\'' +
                '}';
    }
}
