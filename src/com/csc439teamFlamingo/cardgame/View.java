package com.csc439teamFlamingo.cardgame;

import java.io.IOException;

/**
 * Interface for interacting with the players, implemented by the CLIView class
 */
public interface View {
    public int displayTitleScreenAndGetPlayerCount();
    int getNumHoles() throws IllegalArgumentException;
}
