import java.lang.annotation.*;
import java.lang.reflect.Method;
public class anoTestMethod {
	@MyAnnotation(name="someName",  value = "swarup")
	  public void doSomething(){}
	public static void main(String[] args) throws SecurityException, NoSuchMethodException, ClassNotFoundException {
		Method  method = Class.forName("anoTestMethod").getMethod("doSomething");
		Annotation[] annotations = method.getDeclaredAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}


}
}