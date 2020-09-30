package com.av.teamodule.dao;

import com.av.teamodule.models.Tea;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author arseniy
 */
@Local
public interface TeaDao extends Dao<Tea> {
    @Override
    void create(Tea tea);
    @Override
    Tea getById(long id);
    @Override
    List<Tea> getAll();
    @Override
    void update(Tea tea);
    @Override
    void delete(long id);
}