package com.av.cupmodule.dao;

import com.av.cupmodule.models.Cup;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author arseniy
 */
@Local
public interface CupDao extends Dao<Cup>{
    @Override
    void create(Cup cup);
    @Override
    Cup getById(long id);
    @Override
    List<Cup> getAll();
    @Override
    void update(Cup cup);
    @Override
    void delete(long id);
}