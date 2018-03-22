package com.example.topic;

import com.example.topic.model.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


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
            topic.setId((long) i);
            topic.setName("name");
            topic.setDescription("desc");

//            //When
//            topicController.addTopic(topic);
//            System.out.println(topic.toString());
       }

            //topicController.deleteTopic((long) 4);
            //List<Topic> allTopicsD =topicController.getAllTopics();
            //System.out.println(allTopicsD.toString());

            Topic topic = new Topic();
            topic.setId((long) 1);
            topic.setName("new Name");
            topic.setDescription("new Description");
            //topicController.updateTopic(topic, (long) 1);

            //get single topic
            //topicController.getTopic((long)1);
            

        //Then
        //List<Topic> allTopics = topicController.getAllTopics();
        //System.out.println(allTopics.toString());
        //assertEquals(4, allTopics.size());
    }

    }
