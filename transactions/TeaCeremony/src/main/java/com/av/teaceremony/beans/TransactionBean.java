package com.av.teaceremony.beans;

import com.av.cupmodule.beans.JpaCupDao;
import com.av.cupmodule.models.Cup;
import com.av.teamodule.bean.JpaTeaDao;
import com.av.teamodule.models.Tea;
import java.util.Date;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 *
 * @author arseniy
 */

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TransactionBean {
    
    @EJB
    private JpaCupDao cupDao;
    @EJB
    private JpaTeaDao teaDao;
    
    public void successTransaction() {
        cupDao.createRequiredAttr(new Cup("White with blue dots"));
        teaDao.createRequiredAttr(new Tea("English breakfast", new Date()));
    }
    
    public void cupDbFailWithTeaDbRequired() {
        teaDao.createRequiredAttr(new Tea("English breakfast", new Date()));
        cupDao.createNeverAttr(new Cup("White with blue dots"));
    }
    
    public void teaDbFailWithCupDbRequired() {
        cupDao.createRequiredAttr(new Cup("White with blue dots"));
        teaDao.createNeverAttr(new Tea("English breakfast", new Date()));
    }
    
    public void cupDbFailWithTeaDbNotSupport() {
        teaDao.createNotSupportedAttr(new Tea("English breakfast", new Date()));
        cupDao.createNeverAttr(new Cup("White with blue dots"));
    }
    
    public void teaDbFailWithCupDbNotSupport() {
        cupDao.createNotSupportedAttr(new Cup("White with blue dots"));
        teaDao.createRequiredAttr(new Tea("English breakfast", new Date()));
    }
}