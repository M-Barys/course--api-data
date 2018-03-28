package com.example.topic;


import com.example.topic.model.Topic;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

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

    public Topic addTopic(Topic topic){
        topicRepository.save(topic);
        return topic;
    }

    public void deleteTopic(Long id) {
        topicRepository.delete(id);
    }

    public Topic saveOrUpdateTopicForm(Topic topic) {
        Topic savedTopic = addTopic(topic);
        System.out.println("Saved Product Id: " + savedTopic.getId());
        return savedTopic;
    }

    public  List<Topic> filterName(String name){
        return getAllTopics().stream()
             .filter(p -> name.equals(p.getName()) )
             .collect(Collectors.toList());
       }

 }


