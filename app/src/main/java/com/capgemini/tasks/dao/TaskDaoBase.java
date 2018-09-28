package com.capgemini.tasks.dao;

import com.capgemini.tasks.Task;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class TaskDaoBase implements TaskDao {

    @Override
    public List<Task> findAll() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Task> findAll(Sort sort) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public List<Task> findAllById(Iterable<Long> ids) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public <S extends Task> List<S> saveAll(Iterable<S> entities) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void flush() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public <S extends Task> S saveAndFlush(S entity) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteInBatch(Iterable<Task> entities) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteAllInBatch() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Task getOne(Long id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public <S extends Task> List<S> findAll(Example<S> example) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public <S extends Task> List<S> findAll(Example<S> example, Sort sort) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Page<Task> findAll(Pageable pageable) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public <S extends Task> S save(S entity) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public Optional<Task> findById(Long id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public boolean existsById(Long id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public long count() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteById(Long id) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void delete(Task entity) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Task> entities) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public void deleteAll() {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public <S extends Task> Optional<S> findOne(Example<S> example) {
        throw new RuntimeException("Not implemented");
    }

    @Override
    public <S extends Task> Page<S> findAll(Example<S> example, Pageable pageable) {
        throw new RuntimeException("Not implemented");
    }

    @Override
	public <S extends Task> long count(Example<S> example) {
        throw new RuntimeException("Not implemented");
	}

	@Override
	public <S extends Task> boolean exists(Example<S> example) {
        throw new RuntimeException("Not implemented");
	}

}