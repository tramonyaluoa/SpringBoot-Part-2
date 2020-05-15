package com.SpringPart2.demo;
public class User {
    //Declaring the variables
    private int Id;
    private String name;
    private String surname;

    //Instances of user ID,Name,Surname
    public User(int Identity, String Name, String Surname){
        this.Id = Identity;
        this.name = Name;
        this.surname = Surname;
    }

    //getters and setters for Id, Name, Surname
    public int getId() {
        return Id;
    }
    public void setId(int Id) {this.Id = Id;}

    public String getName() {
        return name;
    }
    public void setName(String name) {this.name = name;}

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {this.surname = surname;}
}
