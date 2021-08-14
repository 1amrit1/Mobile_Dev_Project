package com.example.group_project_mobile_dev;

public class User {
    int id;
    String name;
    double balance;
    int[] accNo;


    public User(int id, String name, int balance, int[] accNo) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.accNo = accNo;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int[] getAccNo() {
        return accNo;
    }

    public void setAccNo(int[] accNo) {
        this.accNo = accNo;
    }




}
