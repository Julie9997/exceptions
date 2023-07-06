import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonalInfoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите информацию о человеке (пример: Иванов Иван Иванович " +
                "10.03.1999 1234567890 m), разделяя ее пробелом:");
        String input = scanner.nextLine();
        scanner.close();

        String[] data = input.split(" ");
        if (data.length != 6) {
            System.err.println("Ошибка: неверное количество аргументов. Ожидалось 6, но было получено: " + data.length);
            return;
        }

        String surname = data[0];
        String firstName = data[1];
        String patronymic = data[2];
        LocalDate birthdate;
        try {
            birthdate = LocalDate.parse(data[3], DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        } catch (Exception e) {
            System.err.println("Ошибка: неверный формат даты рождения. Ожидалось дд.ММ.гггг, " +
                    "но получено: " + data[3]);
            return;
        }
        long phoneNumber;
        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: неверный формат номера. Ожидалось целое число без знака, " +
                    "но получено: " + data[4]);
            return;
        }
        char gender;
        if (data[5].length() != 1 || !(data[5].equalsIgnoreCase("f") ||
                data[5].equalsIgnoreCase("m"))) {
            System.err.println("Ошибка: неверный пол. Ожидал ж или м, но было получено: " + data[5]);
            return;
        }
        gender = data[5].charAt(0);

        String output = surname + " " + firstName + " " + patronymic + " " +
                birthdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) + " " + phoneNumber + " " + gender + "\n";

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(surname + ".txt", true));
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("В файл записано: " + output);
    }

}
