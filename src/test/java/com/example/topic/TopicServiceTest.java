package com.example.topic;

import com.example.topic.model.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTest {

    @Autowired
    private TopicService topicService;

    @Test
    public void testTopicAdding() {
        //Given
        for(int i=1 ; i<6; i++ ) {
            Topic topic = new Topic();
            topic.setName("name" + i);
            topic.setDescription("desc" + i);

           //When
            topicService.addTopic(topic);
            //System.out.println(topic.toString());
        }

            topicService.deleteTopic((long) 5);
            System.out.println( topicService.getAllTopics().toString());

            Topic topic = new Topic();
            topic.setId((long) 1);
            topic.setName("new Name");
            topic.setDescription("new Description");
            topicService.saveOrUpdateTopicForm(topic);

            //get single topic
            System.out.println(topicService.getTopic((long)1));
            

        //Then
        System.out.println(topicService.getAllTopics().toString());
        assertEquals(4, topicService.getAllTopics().size());
        }

    }
