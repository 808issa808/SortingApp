package com.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * this is  simple logger
 */
public class MyLogger {
    private static final Logger logger = LogManager.getLogger(MyLogger.class);

    public static Logger getLogger() {
        return logger;
    }
}
