package com.zeman.rps.util;

import com.zeman.rps.domain.Move;
import com.zeman.rps.domain.Outcome;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Executable;
import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class CLIHelperTest {

    private CLIHelper cliHelper = new CLIHelper();
    private static final Class INVALID_PARAM_EXCEPTION_CLASS = InvalidParameterException.class;

    @Test
    void isExitTest() {
        assertTrue(cliHelper.isExit("4"));
        assertFalse(cliHelper.isExit("1"));

        assertThrows(INVALID_PARAM_EXCEPTION_CLASS, () -> cliHelper.isExit("not a number"));
        assertThrows(INVALID_PARAM_EXCEPTION_CLASS, () -> cliHelper.isExit("12345"));
    }

    @Test
    void processChoiceTest() {
        assertEquals(Move.ROCK, cliHelper.processChoice("1"));
        assertEquals(Move.PAPER, cliHelper.processChoice("2"));
        assertEquals(Move.SCISSORS, cliHelper.processChoice("3"));

        assertThrows(INVALID_PARAM_EXCEPTION_CLASS, () -> cliHelper.processChoice("not a number"));
        assertThrows(INVALID_PARAM_EXCEPTION_CLASS, () -> cliHelper.processChoice("12345"));
    }

}