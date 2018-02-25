package com.cts.ejb.training.facade;

import javax.ejb.Remote;
import javax.ejb.Stateless;


@Stateless(name = "employeeManager", mappedName = "employeeManager")
@Remote(EmployeeManager.class)
public class EmployeeManagerImpl implements EmployeeManager {
	private int i=0;
   
	public void print() {
		
	  System.out.println("the value is"+i++ );
	 
		
		
	}
	
	
}
