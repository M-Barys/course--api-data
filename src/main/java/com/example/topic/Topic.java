package com.example.topic;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Data
public class Topic {

    @Id
    private Long id;
    private String name;
    private String description;

}
