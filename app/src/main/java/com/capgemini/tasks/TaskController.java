package com.capgemini.tasks;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private static final Logger logger = LoggerFactory.getLogger(TaskController.class);

    private final TaskCollection tasks = new TaskCollection();

    @Value("${app.task1:Task 1}")
    private String task1;

    @Value("${app.task2:Task 2}")
    private String task2;

    @PostConstruct
    public void init(){
        tasks.add(task1);
        tasks.add(task2);
    }

    @RequestMapping("/tasks")
    public TaskCollection getTasks() {
        logger.info("Get tasks...");
        return tasks;
    }

    @RequestMapping("tasks/new")
    public Task createTask(@RequestParam("message") String message){
        logger.info("Add task...");
        if(tasks.add(message)){
            return tasks.get(tasks.size()-1);
        }
        logger.error("Add task failed !");
        throw new IllegalArgumentException("L'ajout de la tâche a échoué");
    }

    @RequestMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable("taskId") long taskId){
        logger.info("Get task {}...", taskId);
        int index = getIndex(taskId);
        return tasks.get(index);
    }

    @RequestMapping("tasks/{taskId}/remove")
    public void removeTask(@PathVariable("taskId") long taskId){
        logger.info("Remove task {}...", taskId);
        int index = getIndex(taskId);
        tasks.remove(index);
    }

    private int getIndex(long taskId){
        int index = tasks.indexOf(taskId);
        if(index < 0){
            logger.error("L'id {} n'existe pas", taskId);
            throw new IllegalArgumentException("L'id n'existe pas");
        }
        return index;
    }
}