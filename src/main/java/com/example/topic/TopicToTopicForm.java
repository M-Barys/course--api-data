package com.example.topic;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class TopicToTopicForm implements Converter<Topic, TopicForm> {
    @Override
    public TopicForm convert(Topic topic) {
        TopicForm topicForm = new TopicForm();
        topicForm.setId(topic.getId());
        topicForm.setName(topic.getName());
        topicForm.setDescription(topic.getDescription());
        return topicForm;
    }
}
