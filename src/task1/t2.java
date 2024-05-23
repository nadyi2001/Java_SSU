package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Scanner;

class Expression {
    public BigDecimal left, right;
    public String operator;

    public Expression(BigDecimal left, BigDecimal right, String operator) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
}

public class t2 {
    private boolean isIntegerValue(BigDecimal bd) {
        try {
            bd.toBigIntegerExact();
            return true;
        } catch (ArithmeticException ex) {
            return false;
        }
    }

    public void evaluate(Expression exp) {
        if (exp == null) {
            System.out.println("Invalid expression.");
            return;
        }

        switch (exp.operator) {
            case "ADD" -> System.out.println(exp.left.add(exp.right));
            case "SUB" -> System.out.println(exp.left.subtract(exp.right));
            case "MULT" -> System.out.println(exp.left.multiply(exp.right));
            case "POW" -> {
                if ((exp.right.signum() > 0) && (exp.right.compareTo(new BigDecimal("999999999")) < 0) && isIntegerValue(exp.left)) {
                    System.out.println(exp.left.pow(exp.right.intValue()));
                } else {
                    System.out.println("Number " + exp.right + " is out of limits or left part is not integer.");
                }
            }
            case "DIV" -> {
                if (!exp.right.equals(BigDecimal.ZERO)) {
                    System.out.println(exp.left.divideToIntegralValue(exp.right));
                } else {
                    System.out.println("Divisor cannot be zero.");
                }
            }
            case "REM" -> {
                if (!exp.right.equals(BigDecimal.ZERO)) {
                    System.out.println(exp.left.remainder(exp.right));
                } else {
                    System.out.println("Divisor cannot be zero.");
                }
            }
            default -> throw new IllegalArgumentException("Unexpected operator: " + exp.operator);
        }
    }

    public Expression validate(String expression) {
        String[] parts = expression.toUpperCase().split("\\s+");

        if (parts.length != 3) {
            System.out.println("Expression \"" + expression + "\" couldn't be evaluated due to incorrect length.");
            return null;
        }

        String operator = parts[2];
        if (!operator.matches("ADD|SUB|MULT|DIV|REM|POW")) {
            System.out.println("Expression \"" + expression + "\" has an unrecognized operation.");
            return null;
        }

        try {
            BigDecimal left = new BigDecimal(parts[0]);
            BigDecimal right = new BigDecimal(parts[1]);
            return new Expression(left, right, operator);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number in expression: \"" + expression + "\".");
            return null;
        }
    }
    public void run(){
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the file containing expressions: ");
        String filePath = "D:/Microsoft VS Code/task1/src/task1/t2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            t2 calculator = new t2();

            while ((line = reader.readLine()) != null) {
                Expression expression = calculator.validate(line);
                calculator.evaluate(expression);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
        scanner.close();

    }
    public static void main(String[] args) {
        new t2().run();
    }
}
