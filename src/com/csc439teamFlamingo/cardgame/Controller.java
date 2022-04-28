package com.csc439teamFlamingo.cardgame;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class contains all logic for the golf card game, rules for the game can be found here https://en.wikipedia.org/wiki/Golf_(card_game)
 */
public class Controller {
    private View gameView;

    private static Player[] players;
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
        gameView.getNumHoles();
    }

    public int turnSetting(Player[] players){

        int index = players.length;
        Random rand = new Random();
        int random = rand.nextInt(index);
        players[random].setMyTurn(true);
        return random;

    }

    public static void scoreBoard(){
        Player[] scoreboardlist = new Player[players.length];
        for (int i = 0; i <= players.length; i++){
            scoreboardlist[i] = players[i];
        }
        for (int i = 0; i < (scoreboardlist.length - 1); i++){
            for (int j = 0; j < ((scoreboardlist.length - i) - 1); j++){
                if (scoreboardlist[j].calculatePoints() < scoreboardlist[j + 1].calculatePoints()){
                    Player temp = scoreboardlist[j];
                    scoreboardlist[j] = scoreboardlist[j + 1];
                    scoreboardlist[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < scoreboardlist.length; i++) {
            System.out.println(scoreboardlist[i].calculatePoints() + " " + scoreboardlist[i].getPlayerNum());
        }
    }

    public static void finalscoreBoard(){
        Player[] scoreboardlist = new Player[players.length];
        for (int i = 0; i <= players.length; i++){
            scoreboardlist[i] = players[i];
        }
        for (int i = 0; i < (scoreboardlist.length - 1); i++){
            for (int j = 0; j < ((scoreboardlist.length - i) - 1); j++){
                if (scoreboardlist[j].calculatePoints() < scoreboardlist[j + 1].calculatePoints()){
                    Player temp = scoreboardlist[j];
                    scoreboardlist[j] = scoreboardlist[j + 1];
                    scoreboardlist[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < scoreboardlist.length; i++) {
            System.out.println("Player " + scoreboardlist[i].getPlayerNum() + " Won!");
            System.out.println(scoreboardlist[i].calculatePoints() + " " + scoreboardlist[i].getPlayerNum());
        }
    }


    public static int currentPlayer(Player[] players) {

        int index = 0;

        for (int i = 0; i <= players.length - 1; i++) {

            if (players[i].isMyTurn())
                index = i;

        }
        return index;
    }


    public static void turnPassing(Player[] players){

        int check = currentPlayer(players);
        int index = currentPlayer(players);

        if(check+1 < players.length){
            players[index].setMyTurn(false);
            players[index+1].setMyTurn(true);
        }
        else{
            players[index].setMyTurn(false);
            players[0].setMyTurn(true);
        }


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

    public static Player[] getPlayers() {
        return players;
    }

    public static void removePlayer(){
        int index = currentPlayer(players);
        Player[] temp = new Player[players.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < players.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            temp[k++] = players[i];
        }
        players = temp.clone();
    }
}