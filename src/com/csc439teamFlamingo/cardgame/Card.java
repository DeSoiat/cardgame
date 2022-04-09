package com.csc439teamFlamingo.cardgame;

/**
 *
 * Create card object with suit and card number extends abstract method from card class
 *
 */

public class Card {

    private int cardNumber,suit,upORdown;

    /*
    For color
    0 - clubs black, 1 - spades black, 2 - heart red 3 - diamond red

    For face up or down
    0 = up
    1 = down

    For card number 0 - 12
    0 = ace
    1 - 9
    10 = jack
    11 = queen
    12 = king
     */

    public Card(int upORdown, int suit, int cardNumber) {

        this.upORdown = upORdown;
        this.suit = suit;
        this.cardNumber = cardNumber;


    }

    public Boolean isRed() {
        if(suit == 2 || suit == 3 )
            return true;
        else
            return false;
    }

    public Boolean isBlack(){
        if(suit == 0 || suit == 1)
            return true;
        else
            return false;
    }

    public Boolean isFaceDown(){
        if(upORdown == 1)
            return true;
        else
            return false;
    }

    public int getSuit(){
        return suit;
    }

    public int compareTo(Card other) {

        System.out.println("1");

        if(this.getCardNumber() > other.getCardNumber()){
            return 1;
        }
        else if (this.getCardNumber() < other.getCardNumber())
                return -1;
        else
            return 0;

    }



    int getCardNumber() {
        return cardNumber;
    }


}
