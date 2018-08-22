package com.capgemini.tasks;

import static org.assertj.core.api.Assertions.*;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private TaskController controller;

    @Autowired
    private MockMvc mockMvc;

	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
    }
    
    @Test
    public void itShouldGetTasks() throws Exception {
        mockMvc.perform(get("/tasks"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].id").value(1))
            .andExpect(jsonPath("$[0].id", is(1)))
            .andExpect(content().json("[{'id':1,'message':'Faire un Hello World !'},{'id':2,'message':'Adapter le Hello World !'}]"));
    }

}
