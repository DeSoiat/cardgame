package com.csc439teamFlamingo.cardgame;

/**
 *
 * Create card object with suit and card number extends abstract method from card class
 *
 */

public class Card {

    private int cardNumber,suit,upORdown,score;

    /*
    For color
    0 - clubs black, 1 - spades black, 2 - heart red 3 - diamond red

    For face up or down
    0 = up
    1 = down

    For card number 0 - 12
    0 = ace
    1 - 9 = add one for card number
    10 = jack
    11 = queen
    12 = king
     */

    public Card(int upORdown, int suit, int cardNumber) {
        this.upORdown = upORdown;
        this.suit = suit;
        this.cardNumber = cardNumber;
        switch(cardNumber) {
            case 0:
                this.score = 1;
                break;
            case 1:
                this.score = -2;
                break;
            case 10:
            case 11:
                this.score = 10;
                break;
            case 12:
                this.score = 0;
                break;
            default:
                this.score = cardNumber+1;
                break;
        }
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

        if(this.getCardNumber() > other.getCardNumber()){
            return 1;
        }
        else if (this.getCardNumber() < other.getCardNumber())
                return -1;
        else
            return 0;

    }

    public int getCardScore() {
        return score;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setUpORdown(int val) {
        upORdown = val;
    }

    @Override
    public String toString() {
        StringBuilder c = new StringBuilder();
        switch(this.cardNumber) {
            case 0:
                c.append("A");
                break;
            case 10:
                c.append("J");
                break;
            case 11:
                c.append("Q");
                break;
            case 12:
                c.append("K");
                break;
            default:
                c.append(this.cardNumber + 1);
        }
        String color = "R";
        if(this.isBlack()) {
            color = "B";
        }
        c.append(" ").append(color);
        String s = "";
        switch(this.suit) {
            case 0:
                s = "clb";
                break;
            case 1:
                s = "spd";
                break;
            case 2:
                s = "hrt";
                break;
            case 3:
                s = "Dia";
                break;
        }
        c.append(" ").append(s);
        return c.toString();
    }
}
