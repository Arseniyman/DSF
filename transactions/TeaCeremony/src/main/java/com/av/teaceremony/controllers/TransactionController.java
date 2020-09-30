package com.av.teaceremony.controllers;

import com.av.teaceremony.beans.TransactionBean;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author arseniy
 */
@Named("transactionController")
@SessionScoped
public class TransactionController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EJB
    private TransactionBean bean;
    
    public void successTrans() {
        bean.successTransaction();
    }    
    
    public void cupFailTeaReq() {
        bean.cupDbFailWithTeaDbRequired();
    }
    
    public void teaFailCupReq() {
        bean.teaDbFailWithCupDbRequired();
    }
    
    public void cupFailTeaNotSup() {
        bean.cupDbFailWithTeaDbNotSupport();
    }
    
    public void teaFailCupNotSup() {
        bean.teaDbFailWithCupDbNotSupport();
    }
}