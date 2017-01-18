package annotation3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Field;

/**
 * Created by Ootka on 15-Jan-17.
 */
public class Test {
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

    public Test(){}
}
