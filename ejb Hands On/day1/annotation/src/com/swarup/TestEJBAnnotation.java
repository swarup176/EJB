package com.swarup;

import java.lang.reflect.Method;

public class TestEJBAnnotation {
	public static void main(String[] args) {
		Class myTestClass = MyTestClass.class;
		Method[] methods = myTestClass.getDeclaredMethods();
	     
		for(Method m : methods){
			if(!m.getName().equals("welcome")){
				if(m.isAnnotationPresent(MyAnnotation.class))
				{
					MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
					String anotationMethodName = annotation.dependent();
					try {
						Method anotateMethod = MyTestClass.class.getMethod(anotationMethodName, null);
						anotateMethod.invoke(myTestClass.newInstance(), null);
						m.invoke(myTestClass.newInstance(), null);
					} catch (SecurityException e) {						
						e.printStackTrace();
					} catch (NoSuchMethodException e) {					
						e.printStackTrace();
					} catch(Exception e){
						e.printStackTrace();
					}
				}else{
					
				}
			}
		}
	}
}
