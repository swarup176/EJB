package com.cts.ejb.training.facade;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateful(name = "ProjectManager", mappedName = "ProjectManager")
@LocalBean
@StatefulTimeout(value = 1000)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProjectManagerImpl {
	 @EJB
	 private ShoppingCartBean shoppingCartBean;
	
	public void doShopping() throws ShoppingCartException {
		shoppingCartBean.addItem("Bread");
		shoppingCartBean.addItem("Milk");
		shoppingCartBean.addItem("Tea");

		throw new ShoppingCartException();
	}

	@EJB
	TimerSessionBean timerSessionBean;
	@Resource
	SessionContext sessionContext;
	 @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void test() {
		//System.out.println("in side test method");
		//System.out.println(sessionContext.getClass().getName());
		try {
			doShopping();
		} catch (ShoppingCartException e) {
			
			sessionContext.setRollbackOnly();
		}    
		//timerSessionBean.setTimer(30);
	}
}