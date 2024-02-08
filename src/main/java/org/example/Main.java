package org.example;

public class Main {
    public static void main(String[] args) {

        FibonacciSequence.iterative(-5, 0, 1);
        FibonacciSequence.LOGGER.info("\n");
        FibonacciSequence.recursive(5, 0, 1);
        FibonacciSequence.LOGGER.info("\n");
        FibonacciSequence.dp(5, 0, 1);
        FibonacciSequence.LOGGER.info("\n");

    }
}