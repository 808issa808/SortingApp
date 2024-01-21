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
public class HandlerParameterizedTest {

    private final String[] args;

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    public HandlerParameterizedTest(String[] args) {
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


}
