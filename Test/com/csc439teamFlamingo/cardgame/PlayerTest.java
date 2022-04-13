package com.csc439teamFlamingo.cardgame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void setMyTurn() {
        Player[] players = new Player[3];
        players[0] = new Player(0);
        players[0].setMyTurn(true);
        assert (players[0].isMyTurn() == true);
        players[0].setMyTurn(false);
        assert (players[0].isMyTurn()==false);

    }


    @Test
    void isMyTurn() {

        Player[] players = new Player[3];
        Card[]hand = new Card[0];
        players[0] = new Player(0);
        players[0].setMyTurn(true);
        assert (players[0].isMyTurn() == true);
        players[0].setMyTurn(false);
        assert (players[0].isMyTurn()==false);

    }

    @Test
    void displayHand() {

        Player[] players = new Player[3];
        Card[]hand = new Card[3];
        hand[0] = new Card(0,0,0);
        hand[1] = new Card(0,0,1);
        hand[2] = new Card(0,0,2);
        players[0] = new Player(0);
        //players[0].displayHand();



    }

}