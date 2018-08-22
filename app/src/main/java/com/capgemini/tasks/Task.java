package com.capgemini.tasks;

public class Task {

    private final long id;
    private final String message;

    public Task(long id, String message) {
        this.id = id;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
