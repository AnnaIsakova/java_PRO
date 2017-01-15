package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ootka on 15-Jan-17.
 */
//Создать аннотацию, которая принимает параметры для метода. Написать код, который вызовет метод,
//помеченный этой аннотацией, и передаст параметры аннотации в вызываемый метод.
//@Test(a=2, b=5)
//public void test(int a, int b) {…}
public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        Class<?> cls = Test.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                try {
                    MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
                    int param1 = annotation.param1();
                    int param2 = annotation.param2();
                    method.invoke(test, param1, param2);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
