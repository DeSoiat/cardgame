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
        int playnum = view.displayTitleScreenAndGetPlayerCount();
        players = new Player[playnum];
        for (int x = 0; x < playnum; x++) {
            players[x] = new Player(x+1);
        }
        drawPile = new PileOfCards(players.length, true);
        discardPile = new PileOfCards(0, false);
        dealCards();
    }

    public void dealCards() {
        for (int r = 0; r < 2; r++) {
            for(int c = 0; c < 3; c++) {
                for(int player = 0; player < players.length; player++) {
                    players[player].draw(drawPile, r, c);
                }
            }
        }

        for(int p = 0; p < players.length; p++) {
            int card1 = (int)(Math.random() * 6);
            int card2 = (int)(Math.random() * 6);
            while (card2 == card1) {
                card2 = (int)(Math.random() * 6);
            }
            players[p].flipCard(card1/3, card1/2);
            players[p].flipCard(card2/3, card2/2);
        }
    }

    public Player[] getPlayers() {
        return players;
    }
}