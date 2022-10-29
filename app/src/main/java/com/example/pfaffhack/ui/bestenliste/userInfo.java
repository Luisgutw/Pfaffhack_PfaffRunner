package com.example.pfaffhack.ui.bestenliste;

public class userInfo {

    private String userName;
    private int stromErzeugt;
    private int number;


    public userInfo(String userName, int stromErzeugt, int number) {
        this.userName= userName;
        this.stromErzeugt= stromErzeugt;
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getStromErzeugt() {
        return stromErzeugt;
    }
    public  void setStromErzeugt(){
        this.stromErzeugt += 5;
    }

    public void setStromErzeugt(int stromErzeugt) {
        this.stromErzeugt = stromErzeugt;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}