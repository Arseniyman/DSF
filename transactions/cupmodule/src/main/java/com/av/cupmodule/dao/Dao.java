package com.av.cupmodule.dao;

import java.util.List;
import javax.ejb.Local;
/**
 *
 * @author arseniy
 */
@Local
public interface Dao<T> {
    void create(T t);
    T getById(long id);
    List<T> getAll();
    void update(T t);
    void delete(long id);
}