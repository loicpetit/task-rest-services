package com.capgemini.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    final private TaskDao dao;

    @Autowired
    public TaskService(final TaskDao dao){
        this.dao = dao;
    }

    public List<Task> findAll(){
        return dao.findAll();
    }

	public Task save(String message) {
        final Task task = new Task();
        task.setMessage(message);
        final Task taskCreated = dao.save(task);
		return taskCreated;
	}

	public Task find(long taskId) {
		return dao.findById(taskId).orElseThrow(() -> new IllegalArgumentException("Can't find task id"));
	}

	public void remove(long taskId) {
        dao.deleteById(taskId);
	}
}