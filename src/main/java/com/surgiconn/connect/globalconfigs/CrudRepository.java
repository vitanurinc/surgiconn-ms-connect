package com.surgiconn.connect.globalconfigs;

//import org.springframework.data.repository.Repository;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface CrudRepository<T, ID extends Serializable>
        extends Repository {

    <S extends T> S save(S entity);

    T findOne(ID primaryKey);

    Iterable<T> findAll();

    Long count();

    void delete(T entity);

    boolean exists(ID primaryKey);

}