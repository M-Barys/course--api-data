package com.example.topic.model;

import lombok.*;

import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicForm {

    private Long id;
    @NonNull
    @Size(min = 3, max = 20)
    private String name;
    @NonNull
    @Size(min = 1, message = "description must not be empty")
    private String description;

}
