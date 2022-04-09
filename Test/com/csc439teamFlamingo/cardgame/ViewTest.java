package com.csc439teamFlamingo.cardgame;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the View interface as well as for the CLIView class
 */
public class ViewTest {

    private static final InputStream systemIn = System.in;
    private static final PrintStream systemOut = System.out;

    private static ByteArrayInputStream testIn;
    private static ByteArrayOutputStream testOut;

    @BeforeAll
    static void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @AfterAll
    static void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void getNumberOfPlayersHappyPath() {
        final String happyPathNumber = "8";
        provideInput(happyPathNumber);
        View view = new CLIView();
        int x = view.displayTitleScreenAndGetPlayerCount();
        assertEquals(8, x);
    }

    @Test
    public void negativeNumPlayersFailure() {
        final String negativeNumber = "-1";
        provideInput(negativeNumber);
        View view = new CLIView();
        try {
            view.displayTitleScreenAndGetPlayerCount();
            //if it gets past the previous line it's failed
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("ERROR: NEGATIVE NUMBER OF PLAYERS PROVIDED", e.getMessage());
        }
    }

    @Test
    public void alphanumericInputForNumPlayers() {
        final String alphanumeric = "4245e";
        provideInput(alphanumeric);
        View view = new CLIView();
        try {
            view.displayTitleScreenAndGetPlayerCount();
            //if it gets past the previous line it's failed
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("ERROR: NUMBER OF PLAYERS MUST BE A NUMBER", e.getMessage());
        }
    }

    @Test
    public void nothingInputForNumPlayers() {
        final String nothing = "";
        provideInput(nothing);
        View view = new CLIView();
        try {
            view.displayTitleScreenAndGetPlayerCount();
            //if it gets past the previous line it's failed
            fail();
        }
        catch (IllegalArgumentException e) {
            assertEquals("ERROR: NOTHING ENTERED IN NUMBER OF PLAYERS", e.getMessage());
        }
    }
}
