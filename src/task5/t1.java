package task5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class t1 {
    Comparator<ArrayList<String>> comparator = new Comparator<ArrayList<String>>() {
        @Override
        public int compare(ArrayList<String> first, ArrayList<String> second) {
            // Сортировка по рейтингу (по убыванию)
            int firstRating = Integer.parseInt(first.get(4));
            int secondRating = Integer.parseInt(second.get(4));
            int ratingComparison = Integer.compare(secondRating, firstRating);
            if (ratingComparison != 0) {
                return ratingComparison;
            }

            // Сортировка по фамилии (по возрастанию)
            int lastNameComparison = first.get(0).compareTo(second.get(0));
            if (lastNameComparison != 0) {
                return lastNameComparison;
            }

            // Сортировка по имени (по убыванию)
            int firstNameComparison = second.get(1).compareTo(first.get(1));
            if (firstNameComparison != 0) {
                return firstNameComparison;
            }

            // Сортировка по отчеству (по возрастанию)
            return first.get(2).compareTo(second.get(2));
        }
    };

    public void write(String path, Set<ArrayList<String>> data) {
        try (FileWriter writer = new FileWriter(path)) {
            for (ArrayList<String> row : data) {
                for (String item : row) {
                    writer.write(item + " ");
                }
                writer.write("\n");
            }
            System.out.println("Data has already been written to the destination file.");
        } catch (IOException e) {
            System.out.println("Some trouble has occurred while writing result data.");
        }
    }

    public void run() throws IOException {
        in_out choser = new in_out();
        BufferedReader bf = new BufferedReader(new FileReader(choser.choser()));
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        t1 sortByManyParameters = new t1();
        try {
            String line = bf.readLine();
            while (line != null) {
                String[] separated = line.split("\\s+");
                String lastName = separated[0];
                String firstName = separated[1];
                String middleName = separated[2];
                StringBuilder companyName = new StringBuilder();
                for (int i = 3; i < separated.length - 1; i++) {
                    companyName.append(separated[i]).append(" ");
                }

                String rating = separated[separated.length - 1];

                try {
                    Integer.parseInt(rating); // Check if rating is a number
                } catch (NumberFormatException e) {
                    System.out.println("Invalid rating format: " + rating);
                    line = bf.readLine();
                    continue;
                }

                ArrayList<String> current = new ArrayList<>();
                current.add(lastName);
                current.add(firstName);
                current.add(middleName);
                current.add(companyName.toString().trim());
                current.add(rating);
                data.add(current);

                line = bf.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File couldn't be found.");
        }

        bf.close();
        Collections.sort(data, comparator);
        Set<ArrayList<String>> sortedData = new LinkedHashSet<>(data);
        String path = choser.chosen.replace(".txt", "_sorted.txt");
        sortByManyParameters.write(path, sortedData);
    }

    public static void main(String[] args) throws IOException {
        new t1().run();

    }
}



