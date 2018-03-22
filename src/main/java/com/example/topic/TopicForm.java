package com.example.topic;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;

//@Data
public class TopicForm {

    private Long id;
    @NonNull
    @Size(min=3, max=20)
    private String name;
    @NonNull
    @Size(min=1, message = "description must not be empty")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
