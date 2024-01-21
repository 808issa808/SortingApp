package com.example;

import org.apache.logging.log4j.Logger;

import java.util.Arrays;

/**
 * This class does all job
 * it reads and process args
 * covers corner cases
 *
 * @author real_issa
 */
public class Handler {

    /**
     * this is core and vital method of class
     * which sorts given arguments
     * and outprints sorted arguments
     * has checks corner cases and catches exceptions
     *
     * @param args is arguments that come from cli command
     */
    private static final Logger logger = MyLogger.getLogger();

    public void handle(String[] args) {

        if (args.length == 0) {
            System.out.println("No arguments provided.");
            logger.info("No arguments provided.");
            return;
        }
        if (args.length == 1) {
            System.out.println("1 value cannot be sorted");
            logger.info("1 value cannot be sorted");
            return;
        }
        if (args.length > 10) {
            System.out.println("up to 10, means 2 to 10 not less not more");
            logger.info("up to 10, means 2 to 10 not less not more");
            return;
        }

        int[] numbers = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            try {
                numbers[i] = Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid argument: " + args[i]);
                return;
            }
        }

        Arrays.sort(numbers);
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
    }


}
