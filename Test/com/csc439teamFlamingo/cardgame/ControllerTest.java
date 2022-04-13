package com.csc439teamFlamingo.cardgame;

/**
 * Junit tester for the controller class
 */
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {
    private final static Logger LOGGER = Logger.getLogger(ControllerTest.class.getName());

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
    public void testDealCards() {
        final String happyPathNumber = "4";
        provideInput(happyPathNumber);
        Controller controller = new Controller(new CLIView());

        Player[] players = controller.getPlayers();
        assertEquals(4, players.length);
        for(Player p: players) {
           LOGGER.info(p.toString());
        }
    }
}
