package com.example.topic.mapping;

import com.example.topic.model.Topic;
import com.example.topic.model.TopicForm;


import org.springframework.stereotype.Component;

@Component
public class TopicMapObjToForm extends AbstractMapConverter<Topic, TopicForm> {
    public TopicMapObjToForm() {
        super(Topic.class, TopicForm.class);
    }
}
