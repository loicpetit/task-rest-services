package com.capgemini.tasks;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private final TaskCollection tasks = new TaskCollection();

    public TaskController(){
        tasks.add("Faire un Hello World !");
        tasks.add("Adapter le Hello World !");
    }

    @RequestMapping("/tasks")
    public TaskCollection getTasks() {
        return tasks;
    }

    @RequestMapping("tasks/new")
    public Task createTask(@RequestParam("message") String message){
        if(tasks.add(message)){
            return tasks.get(tasks.size()-1);
        }
        throw new IllegalArgumentException("L'ajout de la tâche a échoué");
    }

    @RequestMapping("/tasks/{taskId}")
    public Task getTask(@PathVariable("taskId") long taskId){
        int index = getIndex(taskId);
        return tasks.get(index);
    }

    @RequestMapping("tasks/{taskId}/remove")
    public void removeTask(@PathVariable("taskId") long taskId){
        int index = getIndex(taskId);
        tasks.remove(index);
    }

    private int getIndex(long taskId){
        int index = tasks.indexOf(taskId);
        if(index < 0){
            throw new IllegalArgumentException("L'id n'existe pas");
        }
        return index;
    }
}