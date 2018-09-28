package com.capgemini.tasks.dao;

import com.capgemini.tasks.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskDao extends JpaRepository<Task, Long> {

}