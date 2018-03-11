package com.example.topic;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public List<Topic> getAllTopics() {
        return Lists.newArrayList(topicRepository.findAll());
    }

    public Topic getTopic(Long id){
        return topicRepository.findOne(id);
    }

    public void addTopic(Topic topic){
        topicRepository.save(topic);
    }

    public void updateTopic(Long id, Topic topic) {
        topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.delete(id);
    }

 }


