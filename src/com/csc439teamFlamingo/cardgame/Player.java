package com.csc439teamFlamingo.cardgame;

import java.util.LinkedList;
import java.util.Scanner;

public class Player {

    private Card[] hand = new Card[6];
    private int playerNum;
    boolean myTurn = false;


    public void setMyTurn(boolean value){
        myTurn = value;
    }

    public void setPlayerNum(int value){
        playerNum = value;
    }


    public boolean isMyTurn(){
        if(myTurn){
            //gonna revise later
            System.out.println("Is my turn" + "player : " +playerNum);
            return true;
        }
        else
            return false;

    }

    public void displayHand(){

        // currently, only display number
        System.out.println("Hand : ");
        for(int i=0;i< hand.length;i++){
            System.out.print(hand[i].getCardNumber()+" ");
        }

    }

    public String Action(){
        String action = " ";
        System.out.println("Action you can take");
        System.out.print("Hit, Stand");
        System.out.println("Enter the action you wanna take : ");
        Scanner in = new Scanner(System.in);
        if(in.next().equals("Hit"))
            action = "Hit";
        else if(in.next().equals("Stand"))
            action = "Stand";
        else
            action = "invalid move";

        if(action.equals("invalid move")) Action();

        return action;
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

    public void ask(){
        Scanner in = new Scanner(System.in);
        System.out.println("draw card from draw pile or discard pile ?");
        if(in.nextLine()=="draw pile"){
            Card newCard = new PileOfCards().drawCard(new PileOfCards().returnDrawPile());
            replace(newCard,hand,new PileOfCards().returnDiscardPile());
        }else{
            Card newCard2 = new PileOfCards().drawDiscardPile(new PileOfCards().returnDiscardPile());
            replace(newCard2,hand,new PileOfCards().returnDiscardPile());
        }



    }









}
