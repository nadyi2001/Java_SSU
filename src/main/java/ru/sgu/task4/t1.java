package task4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class t1 {


    public String makeFormatting(String year){
        if (year.strip().length() < 4){
            while (year.length() != 4){
                String zero = "0";
                zero = zero + year;
                year = zero;
            }
            return year;
        } else {
            return year;
        }
    }

    public void count(String dates){
        
        String[] numbers = dates.split("\\ ");
        if (numbers.length != 6){
            System.out.println("Inapropirate dates length");
            return;
        }
        
        numbers[0] = makeFormatting(numbers[0]);
        numbers[3] = makeFormatting(numbers[3]);
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy MM dd");
        String separatedFirst = numbers[0].strip() + " " + numbers[1].strip() + " " + numbers[2].strip();
        String separatedSecond = numbers[3].strip() + " " + numbers[4].strip() + " " + numbers[5].strip();       
        
        try{
            LocalDate date1 = LocalDate.parse(separatedFirst, dtf);
            LocalDate date2 = LocalDate.parse(separatedSecond, dtf);
            System.out.println(Math.abs(ChronoUnit.DAYS.between(date1, date2)));
        } catch (Exception e){
            System.out.println("Inapropirate input string: \"" + dates + "\"");
        }
    }


    public static void main(String[] args) throws IOException{

        String filePath = "D:/Microsoft VS Code/task1/src/task4/t1.txt";
        BufferedReader bf = new BufferedReader(new FileReader(filePath));

        
        try{
            
            String line = bf.readLine();

            while (line != null){
    
                try{
                    new t1().count(line.strip());
                } catch (NullPointerException e){}
            
                line = bf.readLine();
    
            }

        } catch (FileNotFoundException e){
            System.out.println("File couldn't be found.");
        }
        bf.close();
    }

    
}