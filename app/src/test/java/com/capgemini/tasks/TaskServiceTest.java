package com.capgemini.tasks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.capgemini.tasks.dao.TaskDao;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @InjectMocks
    private TaskService service;

    @Mock
    private TaskDao dao;

    @Test
    public void itShouldSaveWithMessage(){
        // given
        final String message = "test";
        final ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
        // when
        service.save(message);
        // then
        verify(dao).save(taskCaptor.capture());
        final Task task = taskCaptor.getValue();
        assertThat(task.getMessage()).isEqualTo(message);
    }
}