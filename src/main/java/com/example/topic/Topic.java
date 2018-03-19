package com.example.topic;

import lombok.Data;

import javax.persistence.*;

@Entity //@Data
public class Topic {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name = "nid")
    private Long nid;
    private String name;
    private String description;

    public Long getId() {
        return nid;
    }

    public void setId(Long id) {this.nid = id;}

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
