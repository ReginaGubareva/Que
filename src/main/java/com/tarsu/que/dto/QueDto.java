package com.tarsu.que.dto;

import com.tarsu.que.domain.User;

public class QueDto {
    private Long id;
    private String queName;
    private String queDescription;
    private User author;

    public QueDto(Long id, String queName, String queDescription, User author) {
        this.id = id;
        this.queName = queName;
        this.queDescription = queDescription;
        this.author = author;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "QueDto{" +
                "id=" + id +
                ", queName='" + queName + '\'' +
                ", queDescription='" + queDescription + '\'' +
                ", author=" + author +
                '}';
    }
}
