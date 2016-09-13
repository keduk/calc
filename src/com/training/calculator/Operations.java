package com.training.calculator;

import java.math.BigDecimal;

/**
 * Contains operations implementation.
 */
public class Operations {

    public static boolean isBinaryOperation(String operation) {
        boolean result = true;
        if ("sqrt".equals(operation) || "c".equals(operation)) {
            result = false;
        }

        return result;
    }

    public static BigDecimal add(BigDecimal arg1, BigDecimal arg2) {
        return arg1.add(arg2);
    }

    public static BigDecimal sub(BigDecimal arg1, BigDecimal arg2) {
        return arg1.subtract(arg2);
    }

    public static BigDecimal multi(BigDecimal arg1, BigDecimal arg2) {
        return arg1.multiply(arg2);
    }

    public static BigDecimal div(BigDecimal arg1, BigDecimal arg2) {
        BigDecimal result = BigDecimal.ZERO;


        if (arg2.equals(BigDecimal.ZERO)) {
            System.out.println("Error. Division by zero.");
        } else {
            result = arg1.divide(arg2);
        }

        return result;
    }

    public static BigDecimal sqrt(BigDecimal arg) {
        return BigDecimal.valueOf(Math.sqrt(arg.doubleValue()));
    }

    public static BigDecimal pow(BigDecimal arg1, BigDecimal arg2) {
        return BigDecimal.valueOf(Math.pow(arg1.doubleValue(), arg2.doubleValue()));
    }
}
