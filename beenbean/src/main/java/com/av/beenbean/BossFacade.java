package com.av.beenbean;

import com.av.beenbean.models.Boss;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author arseniy
 */
@Stateless
public class BossFacade extends AbstractFacade<Boss> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BossFacade() {
        super(Boss.class);
    }
    
}