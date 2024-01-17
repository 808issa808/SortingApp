package com.example;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class HandlerTest {

    private final String[] args;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    public HandlerTest(String[] args) {
        this.args = args;
    }

    @Before
    public void setUp() {
        systemOutRule.clearLog();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{new String[]{"1", "6", "3"}}, {new String[]{"5", "6", "3"}}, {new String[]{"9", "6", "3"}}});
    }

    @Test
    public void handle() {
        Handler handler = new Handler();
        handler.handle(args);
        assertTrue(systemOutRule.getLog().contains("Sorted numbers: "));
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
        handler.handle(new String[]{"1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"});
        assertTrue(systemOutRule.getLog().contains("up to 10, means 2 to 9 not less not more"));
    }
    @Test
    public void handleWrongArgs() {
        Handler handler = new Handler();
        handler.handle(new String[]{"21", "2kmcsd1"});
        assertTrue(systemOutRule.getLog().contains("Invalid argument:"));
    }
}
