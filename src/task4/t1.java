package task4;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class t1 {

    private String formatYear(String year) {
        if (year.strip().startsWith("-")) {
            return String.format("-%04d", Integer.parseInt(year.strip()));
        } else {
            return String.format("%04d", Integer.parseInt(year.strip()));
        }
    }

    private String formatDatePart(String datePart) {
        return String.format("%02d", Integer.parseInt(datePart.strip()));
    }

    private void countDaysBetweenDates(String date1, String date2) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");

        try {
            LocalDate parsedDate1 = LocalDate.parse(date1, dtf);
            LocalDate parsedDate2 = LocalDate.parse(date2, dtf);
            long daysBetween = Math.abs(ChronoUnit.DAYS.between(parsedDate1, parsedDate2));
            System.out.println("Days between the dates: " + daysBetween);
        } catch (Exception e) {
            System.out.println("Invalid input: \"" + date1 + "\" or \"" + date2 + "\"");
        }
    }
    @SuppressWarnings("resource")
    public void run(){

        Scanner scanner = new Scanner(System.in);
        t1 counter = new t1();

        System.out.println("Enter the first date (yyyy MM dd):");
        String[] firstDateParts = scanner.nextLine().split("\\s+");
        if (firstDateParts.length != 3) {
            System.out.println("Invalid date format for the first date.");
            return;
        }

        System.out.println("Enter the second date (yyyy MM dd):");
        String[] secondDateParts = scanner.nextLine().split("\\s+");
        if (secondDateParts.length != 3) {
            System.out.println("Invalid date format for the second date.");
            return;
        }

        String formattedFirstDate = counter.formatYear(firstDateParts[0]) + " " + counter.formatDatePart(firstDateParts[1]) + " " + counter.formatDatePart(firstDateParts[2]);
        String formattedSecondDate = counter.formatYear(secondDateParts[0]) + " " + counter.formatDatePart(secondDateParts[1]) + " " + counter.formatDatePart(secondDateParts[2]);

        counter.countDaysBetweenDates(formattedFirstDate, formattedSecondDate);
        scanner.close();

    }
    public static void main(String[] args) {
        new t1().run();
    }
}
