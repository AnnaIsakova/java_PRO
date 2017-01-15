import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by Ootka on 15-Jan-17.
 */
//Написать класс TextContainer, который содержит в себе строку. С помощью механизма аннотаций указать
//1) в какой файл должен сохраниться текст 2) метод, который выполнит сохранение. Написать класс Saver,
//который сохранит поле класса TextContainer в указанный файл.

public class TextContainer {
    String text = "Some text";

    @Saver(file = "C:\\Users\\Ootka\\Desktop\\from\\result222.txt")
    public void saveToFile(String fileName){
        try (PrintWriter printWriter = new PrintWriter(fileName)){
            printWriter.write(this.text);
            System.out.println("Text '" + text + "' was written to the file " + fileName + ".");
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}
