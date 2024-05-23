package task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


enum Day {
    Sunday,
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday
}

public class t2 {

    public void validateInputAndFindDay(String line) {
        String[] dayNumber = line.split("\\s+");
        if (dayNumber.length != 2) {
            System.out.println("Inapropirate length of line.");
            return;
        }
        try {

            Integer numberOfNextDay = (Integer.parseInt(dayNumber[1].strip()) % 7 + 7) % 7;
            String currentDay = dayNumber[0].substring(0, 1).toUpperCase() + dayNumber[0].substring(1);
            Integer index = -1;

            Day[] days = Day.values();
            for (int i = 0; i < days.length; i++) {
                if (days[i].name().equals(currentDay)) {
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Inapropirate name of day: " + dayNumber[0]);
                return;
            }

            System.out.println(days[(index + numberOfNextDay) % 7]);

        } catch (NumberFormatException e) {
            System.out.println("Only integer number of day should be used.");
            return;
        } catch (NullPointerException e) {
        }

    }

    public static void main(String[] args) throws IOException {

        String filePath = "D:/Microsoft VS Code/task1/src/task4/t2.txt";
        BufferedReader bf = new BufferedReader(new FileReader(filePath));
        try {

            String line = bf.readLine();
            while (line != null) {

                try {
                    new t2().validateInputAndFindDay(line.strip());
                } catch (NullPointerException e) {
                }

                line = bf.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("File couldn't be found.");
        }
        bf.close();
    }

}