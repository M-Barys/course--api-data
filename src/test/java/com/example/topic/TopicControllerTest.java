package com.example.topic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicControllerTest {

    @Autowired
    private TopicController topicController;

    @Test
    public void testTopicAdding() {
        //Given
        for(int i=1 ; i<6; i++ ) {
            Topic topic = new Topic();
            topic.setId("1"+i);
            topic.setName("name");
            topic.setDescription("desc");

            //When
            topicController.addTopic(topic);
            System.out.println(topic.toString());
        }

            topicController.deleteTopic("1"+4);
            List<Topic> allTopicsD =topicController.getAllTopics();
            System.out.println(allTopicsD.toString());

            Topic topic = new Topic();
            topic.setId("1"+1);
            topic.setName("new Name");
            topic.setDescription("new Description");
            topicController.updateTopic(topic,"1"+1);

            //get single topic
            topicController.getTopic("1"+1);
            

        //Then
        List<Topic> allTopics = topicController.getAllTopics();
        System.out.println(allTopics.toString());
        assertEquals(4, allTopics.size());
    }

    }
