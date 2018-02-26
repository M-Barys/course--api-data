package com.example.topic;

import com.example.data.TopicStore;
import com.example.data.TopicStoreRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Streams;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("spring", "Spring Framework", "Spring Framework Description"),
            new Topic("java", "Core Java", "Core Java Description"),
            new Topic("javascript", "JavaScript", "JavaScript Description")
    ));

    @Autowired
    private TopicStoreRepository topicStoreRepository;

    public List<Topic> getAllTopics() {
        Iterable<TopicStore> allIter = topicStoreRepository.findAll();

        List<Topic> topicList = Streams.stream(allIter)
                .map(ts -> ts.createTopic())
                .collect(Collectors.toList());

        return topicList;

    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic){
        TopicStore topicStore = TopicStore.fromTopic(topic);
        topicStoreRepository.save(topicStore);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i = 0; i <topics.size(); i++){
            Topic t = topics.get(i);
            if (t.getId().equals(id)){
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}

