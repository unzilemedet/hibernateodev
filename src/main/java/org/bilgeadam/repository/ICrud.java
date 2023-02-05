package org.bilgeadam.repository;

public interface ICrud <T>{
    void save(T t);
    void getAll();
    void getById(int id);
    void update(T t);
    void delete(int id);
}
