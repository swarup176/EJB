package com.cts.jpa.main;

import javax.annotation.PreDestroy;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

public class StudentListner {

	@PrePersist
	public void informBeforeSave(Object obj){
		
		System.out.println("About to save entity");
	}
	
	@PreRemove
	public void informBeforRemove(Object object){
		System.out.println("About to remove the entity");	
	}
	
	@PreDestroy
	public void informBeforeDestroy(Object object){
		System.out.println("About to destroy the entity");	
	}
	
	@PreUpdate
	public void preupdate(Object obj){
				System.out.println("suceess full preupdate");
	}
	
	@PostUpdate
	public void postupdate(Object obj){
		System.out.println("suceess full postupdate");
     }
	
	@PostLoad
	public void informSuccessfulFetch(Object obj){
				System.out.println("suceess after full fetch");
	}
	
	@PostPersist
	public void informAfterPersist(Object object){
		System.out.println("After persisting the entity");	
	}
	
	@PostRemove
	public void informAfterRemove(Object object){
		System.out.println("After removing the entity");	
	}
	
	
}
