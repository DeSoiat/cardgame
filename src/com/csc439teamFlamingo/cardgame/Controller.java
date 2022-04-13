package com.csc439teamFlamingo.cardgame;
import java.util.Random;

/**
 * This class contains all logic for the golf card game, rules for the game can be found here https://en.wikipedia.org/wiki/Golf_(card_game)
 */
public class Controller {
    private Player[] players;

    public Controller(View view, int playerCount) {


    }

    public int turnSetting(Player[] players){

        int index = players.length;
        Random rand = new Random();
        int random = rand.nextInt(index);
        players[random].setMyTurn(true);
        return random;

    }


    public int currentPlayer(Player[] players) {

        int index = 0;

        for (int i = 0; i <= players.length - 1; i++) {

            if (players[i].isMyTurn())
                index = i;

        }
        return index;
    }


    public void turnPassing(Player[] players){

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


}
