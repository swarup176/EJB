import java.lang.annotation.*;



@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.TYPE})


public @interface MyAnnotation {
    public String name();
    public String value();
}


