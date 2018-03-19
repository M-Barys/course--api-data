package com.example.topic;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by jt on 1/10/17.
 */
@Component
public class TopicFormToTopic implements Converter<TopicForm, Topic> {

    @Override
    public Topic convert(TopicForm topicForm) {
        Topic topic = new Topic();
        if (topicForm.getId() != null  && !StringUtils.isEmpty(topicForm.getId())) {
            topic.setId(new Long(topicForm.getId()));
        }
        topic.setName(topicForm.getName());
        topic.setDescription(topicForm.getDescription());
        return topic;
    }
}
