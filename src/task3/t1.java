package task3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import task5.in_out;


public class t1 {

    public void write(String path, ArrayList<Long> data) {

        try (FileWriter writer = new FileWriter(path)) {
            for (Long item : data) {
                writer.write(item + "\n");
            }
            System.out.println("Data has already written to the distanation file.");

        } catch (IOException e) {
            System.out.println("Some trouble has occured while writing result data.");
        }
    }

    public static void main(String[] args) throws IOException {

        new in_out();
        in_out choser = new in_out();
        BufferedReader bf = new BufferedReader(new FileReader(choser.choser()));
        ArrayList<Long> data = new ArrayList<Long>();

        try {

            String line = bf.readLine();
            while (line != null) {

                Long number;
                try {
                    number = Long.parseLong(line.strip());
                    data.add(number);
                } catch (NumberFormatException e) {
                    System.out.println("Ilegal input: " + line);
                }

                line = bf.readLine();

            }

        } catch (FileNotFoundException e) {
            System.out.println("File couldn't be found.");
        }

        bf.close();

        Predicate<Long> pred = num -> ((num >= Math.pow(9,5)) && (num < Math.pow(9, 9)));

        ArrayList<Long> res = (ArrayList<Long>) data.parallelStream().filter(pred).collect(Collectors.toList());
        String path = choser.chosen.replace(".txt", "_sorted.txt");
        new t1().write(path, res);

    }

}