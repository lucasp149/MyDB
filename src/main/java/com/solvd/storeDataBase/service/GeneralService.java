package com.solvd.storeDataBase.service;

public interface GeneralService<V> {

    void create(V v);
    void delete(Long id);
    void update(Long id, V v);
    V get(Long id);
}
