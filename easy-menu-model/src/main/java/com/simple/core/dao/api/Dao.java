package com.simple.core.dao.api;

import com.simple.core.model.generic.BaseDomain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dzhao on 13/06/2015.
 */
public interface Dao<T extends BaseDomain<ID>, ID extends Serializable> {
    /**
     * Persist the newInstance object into database
     * @param entity
     * @return
     */
    T save(T entity);

    void save(final T... entities);

    /**
     * Retrieve an object that was previously persisted to the database
     * using the indicated id as primary key
     * @param id
     * @return
     */
    T get(ID id);

    /**
     *
     * @return
     */
    List<T> getAll();
    /**
     * Save changes made to a persistent object.
     * @param entity
     * @return
     */
    T update(T entity);

    /**
     * Remove an object from persistent storage in the database
     * @param entity
     */
    void delete(T entity);
}
