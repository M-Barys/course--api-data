package com.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TopicController {

  @Autowired
  private TopicService topicService;


    @RequestMapping("/topics")
    public List<Topic> getAllTopics(){
        return topicService.getAllTopics();
    }

    @GetMapping("/topics")
    public String todoform(Model model){
        model.addAttribute("todoform",new Topic());
        return "todoform";
    }

//    @RequestMapping(value = "/topics",method = RequestMethod.GET)
//    public String todoform(){
//        return "todoform";
//    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method= RequestMethod.POST, value="/topics")
    public void addTopic(@RequestBody Topic topic){
        topicService.addTopic(topic);
    }

    @RequestMapping(method= RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(id, topic);
    }

    @RequestMapping(method= RequestMethod.DELETE, value="/topics/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
    }

}
