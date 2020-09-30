package com.av.teaceremony.controllers;

import com.av.cupmodule.dao.CupDao;
import com.av.cupmodule.models.Cup;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author arseniy
 */
@Named("cupController")
@SessionScoped
public class CupController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB(beanName = "JpaCupDao")
    private CupDao cupDao;
    
    private Cup cup;

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }
    
    public void getCupById() {
        this.cup = cupDao.getById(cup.getId());
    }
    
    public String createCup() {
        cupDao.create(cup);
        return "toIndex";
    }
    
    public List<Cup> getCups() {
        return cupDao.getAll();
    }

    public void deleteCup(long id) {
        cupDao.delete(id);
    }
    
    public void updateCup(Cup cup) {
        cupDao.update(cup);
    }
    
    @PostConstruct
    public void init() {
        cup = new Cup();
    }
    
}