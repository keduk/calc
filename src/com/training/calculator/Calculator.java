package com.training.calculator;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Contains main logic of calculator.
 */
public class Calculator {

    private BigDecimal result;
    private BigDecimal input;
    private String operation;
    private boolean reload = false;

    /**
     * Run infinite calculator.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        displayInfo();

        while(true) {

            reload();

            System.out.println("Result:" + result);
            result = readArgument(scanner);

            while(!reload) {
                System.out.print("Operation:");
                operation = scanner.next();

                if (Operations.isBinaryOperation(operation)) {
                    input = readArgument(scanner);
                }

                switch (operation) {
                    case "+" :
                        result = Operations.add(result, input);
                        break;
                    case "-" :
                        result = Operations.sub(result, input);
                        break;
                    case "*" :
                        result = Operations.multi(result, input);
                        break;
                    case "/" :
                        result = Operations.div(result, input);
                        break;
                    case "sqrt" :
                        result = Operations.sqrt(result);
                        break;
                    case "pow" :
                        result = Operations.pow(result, input);
                        break;
                    case "c" :
                        reload = true;
                        continue;
                    default : System.out.println("Unknown action!");
                }

                System.out.println("Result:" + result);
            }
        }
    }

    private BigDecimal readArgument(Scanner scanner) {
        while(true) {
            try {
                System.out.print("Argument:");
                return scanner.nextBigDecimal();
            } catch (InputMismatchException ex) {
                String res = scanner.next();
                System.out.println(res + " - invalid argument.");
            }
        }
    }

    private void reload() {
        result = BigDecimal.ZERO;
        input = BigDecimal.ZERO;
        reload = false;
    }

    private void displayInfo() {
        System.out.println("Calculator.");
        System.out.println("Operations +, -, *, /, sqrt, pow. c - reload calculator");
    }
}
