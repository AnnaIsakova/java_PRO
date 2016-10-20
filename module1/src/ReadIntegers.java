import java.util.Scanner;

/**
 * Created by Ootka on 20-Oct-16.
 */
public class ReadIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();

        System.out.println("число1 + число2 = " + (num1 + num2));
        System.out.println("число1 - число2 = " + (num1 - num2));
        System.out.println("число1 / число2 = " + (num1 / num2));
        System.out.println("число1 * число2 = " + (num1 * num2));
        System.out.println("число1 % число2 = " + (num1 % num2));

    }
}
