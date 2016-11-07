package homework6;

import java.util.Arrays;

/**
 * Created by Ootka on 08-Nov-16.
 */

//Дано текст. Убрать лишние пробелы, расставить знаки
//        препинания. Пример: «Я длинное предложение Я
//        второе предложение.» -> «Я длинное предложение. Я
//        второе предложение.»
public class TextFormat {
    public static void main(String[] args) {
        String text = "Я длинное предложение Я  второе предложение Я третье         предложение И я - четвертое.";
        String format1 = text.replaceAll("[\\s]{2,}", " ");
        String[] format2 = format1.split(" ");
        StringBuilder  stringBuilder = new StringBuilder(format2[0] + " ");
        for (int i = 1; i < format2.length; i++) {
            if (i < format2.length-1){
                Character c = format2[i+1].charAt(0);
                if (Character.isUpperCase(c)){
                    stringBuilder.append(format2[i] + ". ");
                } else {
                    stringBuilder.append(format2[i] + " ");
                }
            } else {
                stringBuilder.append(format2[i]);
            }
        }

        System.out.println(stringBuilder.toString());
    }
}
