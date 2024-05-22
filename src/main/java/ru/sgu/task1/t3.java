package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class t3 {
    /**
     * Преобразует строку имени и фамилии в формат с инициалами.
     * @param expression строка, содержащая имя, отчество и фамилию
     */
    public void makenNameInitials(String expression) {

        String[] parts = expression.split("\\s+");
        if (parts.length >= 3) {
            // System.out.println("\tString \"" + expression + " \" contains more than 3
            // words.");

        } else if (parts.length == 2) {
            // System.out.println("\tString \"" + expression + " \" contains less than 3
            // words.");
            return;
        } else if ((parts.length == 1) && (parts[0].equals(""))) {
            System.out.println("\n");
            return;
        }

        System.out.println(String.format("%s %s.%s.", parts[1], parts[0].toUpperCase().charAt(0),
                parts[2].toUpperCase().charAt(0)));

    }

    /**
     * Основной метод программы, который запускает процесс считывания и обработки данных из файла.
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the file containing names: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            t3 nameInitials = new t3();
            String line;
            
            while ((line = reader.readLine()) != null) {
                nameInitials.makenNameInitials(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        scanner.close();
    }
}