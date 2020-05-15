package com.SpringPart2.demo;
public interface UserService {
    //User functionality from the list by ID.
    String addUser(int Id, String name, String surname); // add user ID, Name, Surname
    String removeUser(int Id);// remove user by id
    String getUser(int Id); // get user by id
}
