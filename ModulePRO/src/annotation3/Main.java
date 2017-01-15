package annotation3;

import java.io.*;

/**
 * Created by Ootka on 15-Jan-17.
 */
//Написать код, который сериализирует и десериализирует в/из файла все значения полей класса, которые
//отмечены аннотацией @Save.
public class Main {
    public static void main(String[] args) {
        Test test = new Test("some text for serialization", "not for searilation", 22, 55);
        try (FileOutputStream fos = new FileOutputStream("C:\\Users\\Ootka\\Desktop\\from\\result222.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(test);

        } catch (IOException e){
            e.printStackTrace();
        }

        try (FileInputStream fis = new FileInputStream("C:\\Users\\Ootka\\Desktop\\from\\result222.txt");
             ObjectInputStream ois = new ObjectInputStream(fis)){
            Test test1 = (Test) ois.readObject();
            System.out.println(test1.text1);
            System.out.println(test1.text2); // should bu null
            System.out.println(test1.i);
            System.out.println(test1.j); //should be 0

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }


}
