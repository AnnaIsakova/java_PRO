package homework6;

import java.util.Arrays;

/**
 * Created by Ootka on 07-Nov-16.
 */
//Дано текст и определенное слово. Посчитать сколько раз
//        заданное слово встречается в тексте.
public class WordCount {
    public static void main(String[] args) {
        String text = "Олень-северное(1) животное.В летнее время оленям в тайге жарко,а в горах даже в июле холодно. \n" +
                "Олень(2) как бы создан для северных просторов,жёсткого ветра,длинных морозных ночей.Олень(3) легко бежит" +
                " вперёд по тайге,подминает под себя кусты,переплывает быстрые реки.Олень(4) не тонет,потому что каждая" +
                " его шерстинка-это длинная трубочка,которую внутри наполняет воздух.. " +
                "Нос у оленя покрыт серебристой шёрсткой.Если бы шерсти на носу не было,олень(5) бы его отморозил.";

        try {
            String word = "олень";
            int numOfRepeats = countWord(text, word);
            System.out.printf("Слово %s повторяется %d раз.", word, numOfRepeats);
        } catch (IllegalArgumentException e){}

        System.out.println("");

        try {
            String word = "олень олень";
            int numOfRepeats = countWord(text, word);
            System.out.printf("Слово %s повторяется %d раз.", word, numOfRepeats);
        } catch (RuntimeException e){
            System.out.print(e.getMessage());
        }

        System.out.println("");

        try {
            String word = null;
            int numOfRepeats = countWord(text, word);
            System.out.printf("Слово %s повторяется %d раз.", word, numOfRepeats);
        } catch (RuntimeException e){
            System.out.print(e.getMessage());
        }


    }
    public static int countWord(String text, String word){
        int count = 0;

        if (text == null || word == null){
            throw new NullPointerException("Строка/текст не должны быть null.");
        }

        String[] words = text.split("[^A-Za-zА-Яа-я]");
        String[] check = word.split("[^A-Za-zА-Яа-я]");
        if (check.length > 1){
            throw new IllegalArgumentException("Вы ищете больше одного слова за раз, это невозможно.");
        } else {
            for (String s : words) {
                if (s.equalsIgnoreCase(word)){
                    count++;
                }
            }
        }
        return count;
    }
}
