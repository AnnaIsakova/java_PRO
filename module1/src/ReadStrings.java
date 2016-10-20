import java.util.Scanner;

/**
 * Created by Ootka on 20-Oct-16.
 */
public class ReadStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку 1: ");
        String s1 = scanner.nextLine();

        System.out.print("Введите строку 2: ");
        String s2 = scanner.nextLine();

        System.out.print("Введите строку 3: ");
        String s3 = scanner.nextLine();

        System.out.println(s1 + s3);
        System.out.println(s3 + s2 + s1);
        System.out.println(s1 + s2 + s3);
    }
}
