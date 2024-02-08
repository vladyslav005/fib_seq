package org.example;

import java.util.Arrays;
import java.util.logging.*;

public class FibonacciSequence {

    public static final Logger LOGGER = Logger.getLogger(String.valueOf(FibonacciSequence.class));
    static {
        LogManager.getLogManager().reset();
        ConsoleHandler customHandler = new ConsoleHandler();

        customHandler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord logRecord) {
                if (logRecord.getLevel().getName().equals("INFO"))
                    return logRecord.getMessage();
                else
                    return logRecord.getLevel() + ":" + logRecord.getMessage();
            }
        });

        LOGGER.setLevel(Level.FINEST);
        LOGGER.addHandler(customHandler);
    }

    /*
    * Time complexity O(n)
    * Space complexity O(1)
    * */
    static void iterative(int n, int previous, int current) {
        if (n <= 0 || previous < 0 || current < 0) {
            LOGGER.warning("Invalid arguments");
            return;
        }

        int next;
        LOGGER.info(previous + " " + current);

        for (int i = 0; i < n - 2; i++) {
            next = previous + current;
            previous = current;
            current = next;

            LOGGER.info(" " + next);
        }
    }


    /*
     * Time complexity O(n)
     * Space complexity O(1)
     * */
    static void recursive(int n, int previous, int current) {
        if (n < 0 || previous < 0 || current < 0) {
            LOGGER.warning("Invalid arguments");
            return;
        }

        if (n == 0) return;
        else {
            LOGGER.info(previous + " ");
            recursive(--n, current, previous + current);
        }
    }


    /*
     * Time complexity O(n)
     * Space complexity O(n)
     * */
    static void dp(int n, int previous, int current) {
        if (n <= 0 || previous < 0 || current < 0) {
            LOGGER.warning("Invalid arguments");
            return;
        }

        int[] array = new int[n];
        array[0] = previous;
        array[1] = current;

        for (int i = 2; i < n; i++)
            array[i] = array[i-1] + array[i-2];

        Arrays.stream(array).forEach((i) -> LOGGER.info(i + " "));

    }
}
