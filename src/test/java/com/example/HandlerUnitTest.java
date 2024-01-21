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
    public void handleTenPlusArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"});
        assertTrue(systemOutRule.getLog().contains("up to 10, means 2 to 9 not less not more"));
    }

    @Test
    public void handleWrongArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{"21", "2kmcsd1"});
        assertTrue(systemOutRule.getLog().contains("Invalid argument:"));
    }

}