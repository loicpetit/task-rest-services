package com.capgemini.tasks;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private TaskController controller;

    @MockBean
    private TaskService service;

    @Autowired
    private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
    }
    
    @Test
    public void itShouldGetTasks() throws Exception {
        //  Given
        final Task task1 = new Task();
        task1.setId(1L);
        task1.setMessage("Test 1");
        final Task task2 = new Task();
        task2.setId(2L);
        task2.setMessage("Test 2");
        final List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        Mockito.doReturn(tasks).when(service).findAll();
        //  Then
        mockMvc.perform(get("/tasks"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id").value(task1.getId().intValue()))
            .andExpect(jsonPath("$[0].message").value(task1.getMessage()))
            .andExpect(jsonPath("$[1].id", is(task2.getId().intValue())))
            .andExpect(jsonPath("$[1].message", is(task2.getMessage())));
    }

}
