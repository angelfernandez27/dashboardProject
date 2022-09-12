package com.moby.dashboard.service;

import org.springframework.stereotype.Repository;

import java.util.List;


public interface ICrud<T> {

    void create(T t);
    List<T> findAll();
    T findById(Long id);
    void updateById(T t,Long id);
    void DeleteById(Long id);

}
