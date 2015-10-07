package com.github.gherkin.persistence;

import java.util.List;

import org.jvnet.hk2.annotations.Contract;

@Contract
public interface DAO<T> {

    T retrieve(Long id);
    List<T> retrieveAll();
    void remove(Long id) throws Exception;
    void add(T instance);
    List<T> find(Object field) throws IllegalArgumentException;
}
