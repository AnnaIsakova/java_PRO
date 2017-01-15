package annotation3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;

/**
 * Created by Ootka on 15-Jan-17.
 */
public class Test implements Externalizable{
    @Save
    String text1;
    String text2;
    @Save
    int i;
    int j;

    public Test(String text1, String text2, int i, int j){
        this.text1 = text1;
        this.text2 = text2;
        this.i = i;
        this.j = j;
    }

    public Test(){

    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        Class<?> cls = Test.class;
        Field[] fields = cls.getDeclaredFields();
        for (Field f:fields) {
            if (f.isAnnotationPresent(Save.class)){
                f.setAccessible(true);
                try {
                    Object value = f.get(this);
                    out.writeObject(value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        Class<?> cls = Test.class;
        Field[] fields = cls.getDeclaredFields();
        for (Field f:fields) {
            if (f.isAnnotationPresent(Save.class)){
                try {
                    f.set(this, in.readObject());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
