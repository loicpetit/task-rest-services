package com.capgemini.tasks;

import static org.assertj.core.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;

public class TaskCollectionTest {

    private TaskCollection tasks;

    @Before
    public void init(){
        tasks = new TaskCollection();
    }

    @Test
    public void itShouldAddTask(){
        int oldSize = tasks.size();
        tasks.add("message 1");
        int newSize = tasks.size();
        assertThat(newSize).isEqualTo(oldSize + 1);
    }

    @Test
    public void itShouldAddSeveralTasks(){
        int oldSize = tasks.size();
        tasks.add("message 1");
        tasks.add("message 2");
        tasks.add("message 3");
        int newSize = tasks.size();
        assertThat(newSize).isEqualTo(oldSize + 3);
    }

    @Test
    public void itShouldGenerateUniqueTaskId(){
        tasks.add("message 1");//1L
        tasks.add("message 2");//2L, removed
        tasks.add("message 3");//3L
        tasks.remove(1);
        tasks.add("message 4");//4L
        assertThat(tasks.size()).isEqualTo(3);
        assertThat(tasks.get(0).getId()).isEqualTo(1L);
        assertThat(tasks.get(1).getId()).isEqualTo(3L);
        assertThat(tasks.get(2).getId()).isEqualTo(4L);
    }

    @Test
    public void itShouldGetIndexFromId(){
        tasks.add("message 1");//1L
        tasks.add("message 2");//2L, removed
        tasks.add("message 3");//3L
        tasks.remove(1);
        tasks.add("message 4");//4L
        assertThat(tasks.indexOf(3L)).isEqualTo(1);
    }

}