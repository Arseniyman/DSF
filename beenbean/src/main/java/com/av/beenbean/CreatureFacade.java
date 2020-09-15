/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.av.beenbean;

import com.av.beenbean.models.Creature;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author arseniy
 */
@Stateless
public class CreatureFacade extends AbstractFacade<Creature> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CreatureFacade() {
        super(Creature.class);
    }
    
}
