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


    @GetMapping("/topics")
    public String todoform(Model model){
        model.addAttribute("topic",new Topic());
        return "todoform";
    }

    @PostMapping("/topics")
    public String addTopic(@ModelAttribute Topic topic){
        topicService.addTopic(topic);
        return "creationok";
    }

    @RequestMapping("/todolist")
    public String getAllTopics(Model model){
        model.addAttribute("topics", topicService.getAllTopics());
        return "todo";
    }

    @RequestMapping("/topics/{id}")
    public Topic getTopic(@PathVariable Long id){
        return topicService.getTopic(id);
    }

    @RequestMapping(method =RequestMethod.PUT, value="/topics/{id}")
    public void updateTopic(@RequestBody Topic topic, @PathVariable Long id){
        topicService.updateTopic(id, topic);

    }

    @RequestMapping("/topics/delete/{id}")
    public String deleteTopic(@PathVariable Long id, Model model) {
        topicService.deleteTopic(id);

        model.addAttribute("topics", topicService.getAllTopics());
        return "todo";
    }

}
