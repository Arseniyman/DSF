package com.av.cupmodule.beans;

import com.av.cupmodule.dao.CupDao;
import com.av.cupmodule.models.Cup;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author arseniy
 */
@Stateless
@LocalBean
public class JpaCupDao implements CupDao {

    @PersistenceContext(unitName = "my_persistencex_cup")
    private EntityManager em;
    
    @Override
    public void create(Cup cup) {
        em.persist(cup);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createRequiredAttr(Cup cup) {
        em.persist(cup);
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void createNotSupportedAttr(Cup cup) {
        em.persist(cup);
    }
    
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void createNeverAttr(Cup cup) {
        em.persist(cup);
    }
    
    @Override
    public Cup getById(long id) {
        return em.find(Cup.class, id);
    }

    @Override
    public List<Cup> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cup> query = cb.createQuery(Cup.class);
        Root<Cup> c = query.from(Cup.class);
        query.select(c);
        return em.createQuery(query).getResultList();
    }

    @Override
    public void update(Cup cup) {
        em.merge(cup);
    }

    @Override
    public void delete(long id) {
        em.remove(em.find(Cup.class, id));
    }
}