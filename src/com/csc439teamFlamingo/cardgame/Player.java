package com.csc439teamFlamingo.cardgame;

public class Player {
    public Card[][] hand = new Card[2][3];
    private int playerNumber;

    public Player(int player) {
        playerNumber = player;
    }

    public void draw(PileOfCards pile, int row, int column) {
        hand[row][column] = pile.drawCard();
    }

    public void flipCard(int row, int column) {
        hand[row][column].flipCard();
    }

    @Override
    public String toString() {
        StringBuilder playerBoard = new StringBuilder();
        playerBoard.append("================= Player " + playerNumber + " =================\n");
        for(int r = 0; r < 2; r++) {
            for(int c = 0; c < 3; c++) {
                playerBoard.append(hand[r][c]).append("\t\t");
            }
            playerBoard.append("\n");
        }
        return playerBoard.toString();
    }
}
