package com.csc439teamFlamingo.cardgame;

public class creatCrad{

    private int cardNumber,color,upORdown;

    /*
    For color
    0 = red
    1 = black

    For face up or down
    0 = up
    1 = down

    For card number 0 - 12

     */

    public creatCrad(int upORdown,int color,int cardNumber){

        this.upORdown = upORdown;
        this.color = color;
        this.cardNumber = cardNumber;


    }




    public boolean isRed() {
        if(color == 0)
            return true;
        else
            return false;
    }

    public boolean isBlack(){
        if(color == 1)
            return true;
        else
            return false;
    }

    public boolean isFaceDown(){
        if(upORdown == 1)
            return true;
        else
            return false;
    }









}
