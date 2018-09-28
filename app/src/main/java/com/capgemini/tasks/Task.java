package com.capgemini.tasks;

import javax.persistence.*;

@Entity
@Table(name="task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="msg")
    private String message;

    public Task() {}

    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(final String message) {
        this.message = message;
    }

    public Task clone(){
        final Task clone = new Task();
        clone.id = id;
        clone.message = message;
        return clone;
    }

}
