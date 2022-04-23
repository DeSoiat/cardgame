package com.csc439teamFlamingo.cardgame;

import java.util.LinkedList;
import java.util.Scanner;

public class Player {
    public Card[][] hand = new Card[2][3];
    private int playerNum;
    private boolean isDiscard;
    private Card card;

    public Player(int player) {
        playerNum = player;
    }

    public void draw(PileOfCards pile, int row, int column) {
        hand[row][column] = pile.drawCard();
    }

    public void drawDiscard(int row, int column){
        hand[row][column] = discardPile.drawDiscard();
        card = hand[row][column];
        isDiscard = true;
    }

    public void flipCard(int row, int column) {
        hand[row][column].flipCard();
    }

    @Override
    public String toString() {
        StringBuilder playerBoard = new StringBuilder();
        playerBoard.append("================= Player " + playerNum + " =================\n");
        for(int r = 0; r < 2; r++) {
            for(int c = 0; c < 3; c++) {
                playerBoard.append(hand[r][c]).append("\t\t");
            }
            playerBoard.append("\n");
        }
        return playerBoard.toString();
    }

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

        System.out.println("Hand : ");
        for(int i=0;i<2;i++)
            for(int j = 0; j<3;j++)
                System.out.print(hand[i][j].getCardNumber()+" ");

    }

    public String Action(){
        String action = " ";
        System.out.println("Action you can take");
        System.out.print("Hit, Stand, Quit");
        System.out.println("Enter the action you wanna take : ");
        Scanner in = new Scanner(System.in);
        if(in.next().equals("Hit"))
            action = "Hit";
        else if(in.next().equals("Stand"))
            action = "Stand";
        else if(in.next().equals("Quit")) {
            action = "Quit";
            Controller.removePlayer();
        }
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
        if (isDiscard && (discard == card)){
            System.out.println("Cant discard a card you just drew from the discard pile.");
            replace(newCard, hand, discardPile);
        }
        else {
            discardPile.add(0,discard);
        }


        hand[index] = newCard;



        this.displayHand();
        Controller.turnPassing(Controller.getPlayers());

    }

    public boolean isAllCardUp(){

        int faceUpCard = 0;

        for(int i=0; i <= 2;i++){
            for (int j=0;j<=3;j++){
                if(hand[i][j].isFaceUp()){
                    faceUpCard++;
                }
            }
        }

        return faceUpCard == 6;
    }

    public int calculatePoints(){
        int point = 0;

        for(int i=0; i <= 2;i++){
            for (int j=0;j<=3;j++){
                if(hand[i][j].getCardNumber()==0){
                    point++;
                }
                else if(hand[i][j].getCardNumber()==1)
                    point = point-2;
                else if(hand[i][j].getCardNumber()>=3 && hand[i][j].getCardNumber()<10)
                    point = point+hand[i][j].getCardNumber()+1;
                else if(hand[i][j].getCardNumber() == 10 || hand[i][j].getCardNumber() == 11)
                    point = point+10;
            }
        }

        if(hand[0][0].getCardNumber() == hand[1][0].getCardNumber())
            point = point-hand[0][0].getCardNumber() - hand[1][0].getCardNumber();
        if(hand[0][1].getCardNumber() == hand[1][1].getCardNumber())
            point = point-hand[0][1].getCardNumber() - hand[1][1].getCardNumber();
        if(hand[0][2].getCardNumber() == hand[1][2].getCardNumber())
            point = point-hand[0][2].getCardNumber() - hand[1][2].getCardNumber();

        return point;
    }

    public void DealCards(){

        hand = new Card[2][3];
        for(int i=0; i <= 2;i++){
            for (int j=0;j<=3;j++){
                hand[i][j] = new PileOfCards(playerNum,true).drawCard();
            }
        }



    }






}