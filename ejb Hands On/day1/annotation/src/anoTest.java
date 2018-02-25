import java.lang.annotation.*;
@MyAnnotation(name="someName",  value = "Hello World")
public class anoTest {
	public static void main(String[] args) {
		Class<anoTest> aClass = anoTest.class;
		Annotation[] annotations = aClass.getAnnotations();

		for(Annotation annotation : annotations){
		    if(annotation instanceof MyAnnotation){
		        MyAnnotation myAnnotation = (MyAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.name());
		        System.out.println("value: " + myAnnotation.value());
		    }
		}
	}
	

}
