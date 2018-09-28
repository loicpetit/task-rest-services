package com.capgemini.tasks.dao;

import java.util.List;
import java.util.Optional;

import com.capgemini.tasks.Task;
import com.capgemini.tasks.TaskCollection;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("mock")
public class TaskDaoMock extends TaskDaoBase {

    private TaskCollection tasks = new TaskCollection();

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public <S extends Task> S save(S entity) {
        final S newTask = (S)entity.clone();
        newTask.setId(getNewId());
        tasks.add(newTask);
        return newTask;
    }

    @Override
    public Optional<Task> findById(final Long id) {
        final int index = getIndex(id);
        return Optional.of(tasks.get(index));
    }    

    @Override
    public void deleteById(Long id) {
        final int index = getIndex(id);
        tasks.remove(index);
    }

    private int getIndex(final Long id){
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).getId() == id){
                return i;
            }
        }
        throw new IllegalArgumentException("ID not found");
    }

    private long getNewId(){
        if(tasks.size() > 0){
            long maxId = tasks.get(tasks.size() - 1).getId();
            return maxId + 1;
        }
        return 0;
    }

}