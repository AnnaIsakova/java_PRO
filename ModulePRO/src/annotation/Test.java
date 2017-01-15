package annotation;

/**
 * Created by Ootka on 15-Jan-17.
 */
public class Test {

    @MyAnnotation(param1 = 3, param2 = 5)
    public void test(int a, int b) {
        System.out.println("Method 'test': " + a + "+" + b + "=" + (a + b));
    }

    public void test1(int a, int b){
        System.out.println("This method should not work.");
        System.out.println("a + b = " + (a + b));
    }

    @MyAnnotation(param1 = 2, param2 = 10)
    public void test2(int a, int b) {
        System.out.println("Method 'test2': " + a + "+" + b + "=" + (a + b));
    }
}