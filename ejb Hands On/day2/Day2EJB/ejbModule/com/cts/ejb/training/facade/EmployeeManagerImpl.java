package com.cts.ejb.training.facade;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateful(name = "employeeManager", mappedName = "employeeManager")
@Interceptors(TestInterceptor.class)
@Remote(EmployeeManager.class)
public class EmployeeManagerImpl implements EmployeeManager {
	private int i=0;
   @EJB
   ProjectManagerImpl projectManager;
	public void print() {
		
	//  System.out.println("the value is"+i++ );
	 projectManager.test();
		
		
	}
	@PostConstruct
	void test1() {
		//System.out.println("Hi i am Post Construct inside the ejb");
	}
	
}
