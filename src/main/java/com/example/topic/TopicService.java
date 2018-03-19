package com.example.topic;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private TopicFormToTopic topicFormToTopic;

    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    public TopicService(TopicFormToTopic topicFormToTopic){
    this.topicFormToTopic=topicFormToTopic;
    }


    public List<Topic> getAllTopics() {
        return Lists.newArrayList(topicRepository.findAll());
    }

    public Topic getTopic(Long id){
        return topicRepository.findOne(id);
    }

    public Topic addTopic(Topic topic){
        topicRepository.save(topic);
        return topic;
    }

    public void deleteTopic(Long id) {
        topicRepository.delete(id);
    }

    public Topic saveOrUpdateTopicForm(TopicForm topicForm) {
        Topic savedTopic = addTopic(topicFormToTopic.convert(topicForm));

        System.out.println("Saved Product Id: " + savedTopic.getId());
        return savedTopic;
    }

 }


