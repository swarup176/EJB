package com.cts.ejb.training.facade;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class TestInterceptor {
	@PostConstruct
	void test(InvocationContext invocationContext) {
		//System.out.println("Hi i am Post Construct");
		try {
			invocationContext.proceed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@PreDestroy
	void test1(InvocationContext invocationContext) {
		//System.out.println("Hi i am Pre Destroy");
	}
	@AroundInvoke
	private Object profile(InvocationContext invocationContext) throws Exception
	{
		long t1=System.nanoTime();
		Object result=invocationContext.proceed();
		long t2=System.nanoTime();
	//	System.out.println(invocationContext.getMethod().getName()+ " took "+ ((t2-t1)/1000.0)+ "namo second ");
	return result;
	}
}
