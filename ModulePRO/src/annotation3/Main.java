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
        MySerialization.writeToFile("C:\\Users\\Ootka\\Desktop\\from\\result222.txt", test);
        Test test1 = (Test) MySerialization.readFromFile("C:\\Users\\Ootka\\Desktop\\from\\result222.txt");
        System.out.println(test1.text1);
        System.out.println(test1.text2);
        System.out.println(test1.i);
        System.out.println(test1.j);
    }


}
