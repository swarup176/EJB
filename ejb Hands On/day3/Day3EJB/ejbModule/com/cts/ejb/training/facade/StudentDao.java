package com.cts.ejb.training.facade;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cts.ejb.training.entiry.StudentEntity;

/**
 * Session Bean implementation class EmployeeDao
 */
@Stateless(mappedName = "StudentDao", name = "StudentDao")
@LocalBean
@TransactionManagement(TransactionManagementType.CONTAINER)
public class StudentDao {

	@PersistenceContext(unitName = "jdpUnit")
	private EntityManager entityManager;
    
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void  insert(String name){
		StudentEntity test= new  StudentEntity();
		test.setName(name);
		entityManager.persist(test);
		
	}
}
