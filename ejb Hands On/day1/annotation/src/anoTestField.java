import java.lang.annotation.*;
import java.lang.reflect.*;
public class anoTestField {
	 @MyAnnotation(name="someName",  value = "Hello World")
	  public String temp = "swarup";
   public static void main(String[] args) throws Exception {
	   
	   Field field = Class.forName("anoTestField").getField("temp");
	   Annotation[] annotations = field.getDeclaredAnnotations();

	   for(Annotation annotation : annotations){
	       if(annotation instanceof MyAnnotation){
	           MyAnnotation myAnnotation = (MyAnnotation) annotation;
	           System.out.println("name: " + myAnnotation.name());
	           System.out.println("value: " + myAnnotation.value());
	       }
	   }

}
}
