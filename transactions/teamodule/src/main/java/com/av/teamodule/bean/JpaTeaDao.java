package com.av.teamodule.bean;

import com.av.teamodule.dao.TeaDao;
import com.av.teamodule.models.Tea;
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
public class JpaTeaDao implements TeaDao {

    @PersistenceContext(unitName = "my_persistencex_tea")
    private EntityManager em; 
    
    @Override
    public void create(Tea tea) {
        em.persist(tea);
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void createRequiredAttr(Tea tea) {
        em.persist(tea);
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void createNotSupportedAttr(Tea tea) {
        em.persist(tea);
    }
    
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void createNeverAttr(Tea tea) {
        em.persist(tea);
    } 

    @Override
    public Tea getById(long id) {
        return em.find(Tea.class, id);
    }

    @Override
    public List<Tea> getAll() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tea> query = cb.createQuery(Tea.class);
        Root<Tea> c = query.from(Tea.class);
        query.select(c);
        return em.createQuery(query).getResultList();
    }

    @Override
    public void update(Tea tea) {
        em.merge(tea);
    }

    @Override
    public void delete(long id) {
        em.remove(em.find(Tea.class, id));
    }
}