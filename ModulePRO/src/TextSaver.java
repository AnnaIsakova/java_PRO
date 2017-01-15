import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Ootka on 15-Jan-17.
 */
public class TextSaver {
    public static void main(String[] args) {
        TextContainer text = new TextContainer();
        Class<?> cls = TextContainer.class;
        Method[] methods = cls.getDeclaredMethods();
        for (Method m:methods) {
            if (m.isAnnotationPresent(Saver.class)){
                Saver annotation = m.getAnnotation(Saver.class);
                try {
                    m.invoke(text, annotation.file());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
