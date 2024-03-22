package com.example.demo;

class Account {
    private String accountID;
    private String accountUsername;
    private String accountPassword;
    
    //Constructor methods
    public Account(){

    }

    public Account(String accUser, String accPass){
        this.setAccountUsername(accUser);
        this.setAccountPassword(accPass);
    }

    //Mutator Methods
    public void setAccountID(String a){
        accountID = a;
    }

    public void setAccountUsername(String a){
        accountUsername = a;
    }

    public void setAccountPassword(String a){
        accountPassword = a;
    }

    //Accessor Methods
    public String getAccountID(){
        return accountID;
    }

    public String getAccountUsername(){
        return accountUsername;
    }

    public String getAccountPassword(){
        return accountPassword;
    }
}
