package com.example.topic.mapping;

import com.example.topic.model.Topic;
import com.example.topic.model.TopicForm;
import org.springframework.stereotype.Component;

@Component
public class TopicMapFormToObj extends AbstractMapConverter<TopicForm, Topic> {
    public TopicMapFormToObj() {
        super(TopicForm.class, Topic.class);
    }
}
