package com.capgemini.tasks;

import java.util.ArrayList;

public class TaskCollection extends ArrayList<Task> {

    public boolean add(String message){
        long id = getNewId();
        Task task = new Task();
        task.setId(id);
        task.setMessage(message);
        return add(task);
    }

    public int indexOf(long id){
        for(int i=0; i<this.size(); i++){
            Task task = this.get(i);
            if(task.getId() == id){
                return i;
            }
        }
        return -1;
    }

    private long getNewId(){
        long id = 1L;
        if(this.size() > 0){
            Task lastTask = this.get(this.size() - 1);
            id = lastTask.getId() + 1L;
        }
        return id;
    }

}