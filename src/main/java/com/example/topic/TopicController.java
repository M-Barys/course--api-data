package com.example.topic;

import com.example.topic.mapping.TopicMapFormToObj;
import com.example.topic.mapping.TopicMapObjToForm;
import com.example.topic.model.Topic;
import com.example.topic.model.TopicForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;

@Controller
public class TopicController {

    @Autowired
    private TopicMapObjToForm topicMapObjToForm;

    @Autowired
    private TopicMapFormToObj topicMapFormToObj;

    @Autowired
    private TopicService topicService;


    @GetMapping("/topics")
    public String todoform(Model model) {
        model.addAttribute("topicForm", new TopicForm());
        return "todoform";
    }

    @PostMapping("/topics")
    public String addTopic(@ModelAttribute @Valid TopicForm topicForm, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("topicForm", topicForm);
            return "todoform";
        }
        Topic toAdd = topicMapFormToObj.convert(topicForm);
        Topic savedTopic = topicService.saveOrUpdateTopicForm(toAdd);
        return "redirect:/topics/show/" + savedTopic.getId();
    }

    @RequestMapping("/topics/show/{id}")
    public String getTopic(@PathVariable String id, Model model) {
        model.addAttribute("topic", topicService.getTopic(Long.valueOf(id)));
        return "creationok";
    }

    @RequestMapping("/todolist")
    public String getAllTopics(Model model) {
        model.addAttribute("topics", topicService.getAllTopics());
        return "todo";
    }

    @RequestMapping("/topics/edit/{id}")
    public String getTopic(@PathVariable Long id, Model model) {
        Topic topic = topicService.getTopic(id);
        TopicForm topicForm = topicMapObjToForm.convert(topic);

        model.addAttribute("topicForm", topicForm);
        return "todoform";
    }

    @RequestMapping("/topics/delete/{id}")
    public String deleteTopic(@PathVariable Long id, Model model) {
        topicService.deleteTopic(id);

        model.addAttribute("topics", topicService.getAllTopics());
        return "todo";
    }

    @RequestMapping("/topics/filter/{name}")
    public String filterName(@PathVariable String name, Model model){
        model.addAttribute("topics", topicService.filterName(name));
        System.out.println(topicService.filterName(name));
        return"todo";
    }

    @RequestMapping("/{buttonlist}")
    public  void filterButton(Model model){
        model.addAttribute("buttonlist", topicService.filterButton());
        System.out.println(topicService.filterButton());
        //return "todo";
    }
}
