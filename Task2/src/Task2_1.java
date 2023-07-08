// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
// и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float number;
        boolean flag = true;

        while (flag) {
            System.out.println("Введите дробное число: ");
            try {
                number = sc.nextFloat();
                System.out.println("Ваше число: " + number);
                flag = false;
            } catch (InputMismatchException e) {
                System.out.println("Это не число. Попробуйте снова.");
                sc.nextLine();
            }
        }
    }
}