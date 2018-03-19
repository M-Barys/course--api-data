package com.example.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TopicController {

    private TopicToTopicForm topicToTopicForm;

    @Autowired
    public void setTopicToTopicForm(TopicToTopicForm topicToTopicForm) {
        this.topicToTopicForm = topicToTopicForm;
    }

  @Autowired
  private TopicService topicService;


    @GetMapping("/topics")
    public String todoform(Model model){
        model.addAttribute("topicForm",new TopicForm());
        return "todoform";
    }

    @PostMapping("/topics")
    public String addTopic(@ModelAttribute TopicForm topicForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "productform";
        }

        Topic savedTopic = topicService.saveOrUpdateTopicForm(topicForm);

        return "redirect:/topics/show/" + savedTopic.getId();
    }

    @RequestMapping("/topics/show/{id}")
    public String getTopic(@PathVariable String id, Model model) {
        model.addAttribute("topic", topicService.getTopic(Long.valueOf(id)));
        return "creationok";
    }

    @RequestMapping("/todolist")
    public String getAllTopics(Model model){
        model.addAttribute("topics", topicService.getAllTopics());
        return "todo";
    }

    @RequestMapping("/topics/edit/{id}")
    public String getTopic(@PathVariable Long id, Model model){
        Topic topic = topicService.getTopic(id);
        TopicForm topicForm = topicToTopicForm.convert(topic);

        model.addAttribute("topicForm", topicForm);
        return "todoform";
    }

    @RequestMapping("/topics/delete/{id}")
    public String deleteTopic(@PathVariable Long id, Model model) {
        topicService.deleteTopic(id);

        model.addAttribute("topics", topicService.getAllTopics());
        return "todo";
    }

}
