package com.moby.dashboard.service;

import java.util.List;


public interface ICrud<T> {

    void create(T t);
    List<T> findAll();
    T findById(Long id);
    void updateById(T t,Long id);
    void deleteById(Long id);

}
