package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

import static org.junit.Assert.assertTrue;

public class HandlerUnitTest {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();


    @Before
    public void setUp() {
        systemOutRule.clearLog();
    }

    @Test
    public void handleZeroArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{});
        assertTrue(systemOutRule.getLog().contains("No arguments provided."));
    }

    @Test
    public void handleSingleArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{"1"});
        assertTrue(systemOutRule.getLog().contains("1 value cannot be sorted"));
    }

    @Test
    public void handleTenMoreArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"});
        assertTrue(systemOutRule.getLog().contains("up to 10, means 2 to 10 not less not more"));
    }

    @Test
    public void handleTenArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{"10", "9", "8", "7", "6", "5", "4", "2", "3", "1"});
        assertTrue(systemOutRule.getLog().contains("Sorted numbers: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]"));
    }

    @Test
    public void handleWrongArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{"21", "2kmcsd1"});
        assertTrue(systemOutRule.getLog().contains("Invalid argument:"));
    }

}