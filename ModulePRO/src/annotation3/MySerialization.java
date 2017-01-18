package annotation3;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;

/**
 * Created by Ootka on 16-Jan-17.
 */
public class MySerialization {
    private static String writeObject(Object object){
        String result = "";
        StringBuilder sb = new StringBuilder();
        sb.append("class=" + object.getClass().getName() + System.lineSeparator());
        Class<?> cls = object.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (Field f:fields) {
            if (f.isAnnotationPresent(Save.class)){
                f.setAccessible(true);
                try {
                    Object value = f.get(object);
                    sb.append(f.getName()+"="+value + System.lineSeparator());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        result = sb.toString();
        return result;
    }

    public static void writeToFile(String fileName, Object object){
        try {
            PrintWriter printWriter = new PrintWriter(fileName);
            String s = writeObject(object);
            printWriter.write(s);
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    private static Object readObject(String input){
        Object object = null;
        String[] lines = input.split(System.lineSeparator());
        String[] classArr = lines[0].split("=");
        Class c = null;
        try {
            c = Class.forName(classArr[1]);
            object = c.newInstance();
            for (int i = 1; i < lines.length; i++) {
                String[] keyVal = lines[i].split("=");
                Field field = c.getDeclaredField(keyVal[0]);
                field.setAccessible(true);
                if (field.isAnnotationPresent(Save.class)){
                    Type type = field.getType();
                    if (type.getTypeName().equals("int")){
                        int val = Integer.parseInt(keyVal[1]);
                        field.set(object, val);
                    } else {
                        field.set(object, keyVal[1]);
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static Object readFromFile(String fileName){
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)))){
            StringBuilder stringBuilder = new StringBuilder();
            String currLine;
            while ((currLine = bufferedReader.readLine()) != null){
                stringBuilder.append(currLine + System.lineSeparator());
            }
            return readObject(stringBuilder.toString());
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
