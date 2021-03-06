package com.cts.ejb.training.facade;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TimerService;
import javax.transaction.UserTransaction;
@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class TimerSessionBean {
    @Resource
    TimerService timerService;
    
    @PostConstruct
    public void test1()
    {
    	//System.out.println("I am a singleton instance of TimerSessionBean");
    }
   
   @Lock(LockType.READ)
   @AccessTimeout(value=1000)
    public void setTimer(long intervalDuration) {
	   
        System.out.println("Setting a programmatic timeout for "
                + intervalDuration + " milliseconds from now.");
        Timer timer = timerService.createTimer(intervalDuration, 
                "Created new programmatic timer");
    }
    
    @Timeout
  
    public void programmaticTimeout(Timer timer) {
       
        System.out.println("Programmatic timeout occurred.");
    }

  //  @Schedule(minute="*/3", hour="*")
    public void automaticTimeout() {
       
        System.out.println("Automatic timeout occured");
    }

   
}