package homework6;

import java.util.Arrays;

/**
 * Created by Ootka on 07-Nov-16.
 */
//Дано текст из 3-х слов “word1 word2 word3”. Поменять 1-е
//        и 3-е слова местами и вывести на экран результат.
public class ChangeWords {
    public static void main(String[] args) {
        String text = "word1 word2 word3";
        String[] words = text.split(" ");
        String temp = words[0];
        words[0] = words[words.length-1];
        words[words.length-1] = temp;
        System.out.println(Arrays.toString(words));
    }
}
