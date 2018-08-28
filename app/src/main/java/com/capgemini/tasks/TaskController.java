package com.capgemini.tasks;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    @Value("${app.title:Title}")
    private String title;

    @Value("${app.version:0.0.1}")
    private String version;

    private final TaskService service;

    private class Root {
        private String title;
        private String version;

        public String getTitle(){ return this.title; }
        public void setTitle(final String title){ this.title = title; }

        public String getVersion(){ return this.version; }
        public void setVersion(final String version){ this.version = version; }
    }

    @Autowired
    public TaskController(final TaskService service){
        this.service = service;
    }

    @RequestMapping("/")
    public Root getRoot(){
        return new Root(){{
            setTitle(title);
            setVersion(version);
        }};
    } 

    @RequestMapping("/tasks")
    public List<Task> getTasks() {
        logger.info("Get tasks...");
        return service.findAll();
    }

    @RequestMapping("tasks/new")
    public Task createTask(@RequestParam("message") String message){
        logger.info("Add task...");
        final Task task = service.save(message);
        return task;
    }

    @RequestMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable("taskId") long taskId){
        logger.info("Get task {}...", taskId);
        final Task task = service.find(taskId);
        return task;
    }

    @RequestMapping("tasks/{taskId}/remove")
    public void removeTask(@PathVariable("taskId") long taskId){
        logger.info("Remove task {}...", taskId);
        service.remove(taskId);
    }

}