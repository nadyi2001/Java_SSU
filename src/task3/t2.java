package task3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Comparator;

import task5.in_out;

public class t2 {

    public ArrayList<Long> Reader(in_out choser) {
        try (BufferedReader bf = new BufferedReader(new FileReader(choser.choser()))) {
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
            return data;
        } catch (IOException e) {
            return null;
        }
    }

    public Long getSecondMax(ArrayList<Long> data) {
        return data
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Array is empty or it contains less than 2 unique elements."));
    }

    public Long getThirdMin(ArrayList<Long> data) {
        return data
                .stream()
                .distinct()
                .sorted()
                .skip(2)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Array is empty or it contains less than 3 unique elements."));
    }

    public void run() {

        ArrayList<Long> data = Reader(new in_out());

        System.out.println("Second maximum element: " + getSecondMax(data));
        System.out.println("Third minimum element: " + getThirdMin(data));
    }

    public static void main(String[] args) throws IOException {
        new t2().run();
    }

}
