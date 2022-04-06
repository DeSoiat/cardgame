package com.csc439teamFlamingo.cardgame;

/**
 * Interface for interacting with the players, implemented by the CLIView class
 */
public interface View {
    public String promptUser();
    public String recieveUserInput();
}
