package annotation;

import java.beans.Transient;
import java.lang.annotation.*;

public class Main {
    public static void main(String[] args) {

    }
}

@Deprecated
//@MyAnn(i = 5) - error because @Target FIELD and METHOD
class myClass {
    @Deprecated
    @MyAnn // All good
    int i;

    @Deprecated
    myClass() {
    }

    @Transient
    @Deprecated
    @MyAnn // All good
    public void myMeth(@Deprecated int ert) {
        @Deprecated
        int reter;
    }
}

class myClass2 extends myClass {

}

@Inherited // если написано, то наследники будут помечены аннотацией @MyAnn
@Retention(RetentionPolicy.CLASS) // видимость в моменты жизненного цикла программы
@Target({ElementType.PACKAGE, ElementType.FIELD, ElementType.METHOD}) // ограничение применения, к чему можно присобачить
@interface MyAnn {
    boolean run() default true;

    int i() default 23;
//    String value();
}
