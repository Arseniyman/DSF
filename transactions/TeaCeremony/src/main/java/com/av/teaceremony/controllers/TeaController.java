package com.av.teaceremony.controllers;

import com.av.teamodule.dao.TeaDao;
import com.av.teamodule.models.Tea;
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
@Named("teaController")
@SessionScoped
public class TeaController implements Serializable {
    
    private static final long serialVersionUID = -1507373694984101022L;
    
    @EJB(beanName = "JpaTeaDao")
    private TeaDao teaDao;
    
    private Tea tea;

    public Tea getTea() {
        return tea;
    }

    public void setTea(Tea tea) {
        this.tea = tea;
    }
    
    public void geTeaById(long id) {
        this.tea = teaDao.getById(tea.getId());
    }
    
    public String createTea() {
        teaDao.create(tea);
        return "toIndex";
    }
    
    public List<Tea> getTeas() {
        return teaDao.getAll();
    }

    public void deleteTea(long id) {
        teaDao.delete(id);
    }
    
    public void updateTea(Tea tea) {
        teaDao.update(tea);
    }
    
    @PostConstruct
    public void init() {
        tea = new Tea();
    }
}