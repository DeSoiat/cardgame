package com.csc439teamFlamingo.cardgame;

/**
 * This class contains all logic for the golf card game, rules for the game can be found here https://en.wikipedia.org/wiki/Golf_(card_game)
 */
public class Controller {
    private View gameView;

    private Player[] players;
    private PileOfCards drawPile;
    private PileOfCards discardPile;

    public Controller(View view) {
        gameView = view;
        players = new Player[view.displayTitleScreenAndGetPlayerCount()];
        drawPile = new PileOfCards(players.length, true);
        discardPile = new PileOfCards(0, false);
    }
}
