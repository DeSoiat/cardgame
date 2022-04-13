package com.csc439teamFlamingo.cardgame;

import java.util.LinkedList;
import java.util.Scanner;

public class Player {

    private Card[] hand = new Card[6];
    private int playerNum;
    boolean myTurn = false;


    Player(int playerNum,Card[]hand){
        this.playerNum = playerNum;
        this.hand = hand;
    }

    public void setMyTurn(boolean value){
        myTurn = value;
    }

    public void setPlayerNum(int value){
        playerNum = value;
    }


    public boolean isMyTurn(){
        if(myTurn){
            System.out.println("Is my turn " + "player : " +playerNum);
            return true;
        }
        else
            return false;

    }

    public void displayHand(){

        System.out.print("Hand : ");
        for(int i=0;i< hand.length;i++){
            System.out.print(hand[i].getCardNumber()+" ");
        }

    }


    public void replace(Card newCard,Card[] hand, LinkedList<Card> discardPile){

        this.displayHand();
        int index = 0;
        System.out.println("enter the index of card you wanna replace: ");
        Scanner input = new Scanner(System.in);
        index = input.nextInt();

        Card discard = hand[index];

        hand[index] = newCard;

        discardPile.add(0,discard);

        this.displayHand();

    }





}
