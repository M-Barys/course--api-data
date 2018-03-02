//package com.example.data;
//
//import com.example.topic.Topic;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class TopicStore {
//    @Id
//    @GeneratedValue(strategy= GenerationType.AUTO)
//    private Long id;
//    private String name;
//    private String description;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public static TopicStore fromTopic(Topic topic){
//        TopicStore ts = new TopicStore();
//        ts.setName(topic.getName());
//        ts.setDescription(topic.getDescription());
////        String id = topic.getId();
////        if( id != null) {
////            ts.setId(Long.decode(id));
////        }
//        return ts;
//    }
//
////    public Topic createTopic(){
////        Topic t = new Topic();
////        t.setDescription(description);
////        t.setName(name);
////        t.setId(id);
////        return t;
////    }
//}
