package com.example.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicControllerTest {

    @Autowired
    private TopicController topicController;

    @Test
    public void testTopicCreation() {
        //Given
        Topic topic = new Topic();
        topic.setName("name");
        topic.setDescription("desc");

        //When
        topicController.addTopic(topic);

        //Then
        List<Topic> allTopics = topicController.getAllTopics();
        assertTrue(allTopics.size() == 1);
    }
}