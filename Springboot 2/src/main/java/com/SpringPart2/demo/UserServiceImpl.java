package com.SpringPart2.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

public class UserServiceImpl implements FakeRepoInterface, UserService {

    //inject fake repo dependency
    @Autowired
    private FakeRepo fakeRepo;
    @Override
    public String addUser(int Id, String name, String surname) {
        fakeRepo = new FakeRepo ();                                 //inserts user
        return fakeRepo.insertUser(Id, name, surname);
    }
    @Override
    public String removeUser(int Id) {
        fakeRepo = new FakeRepo ();                                //removes user by ID
        return fakeRepo.deleteUser(Id);
    }
    @Override
    @Cacheable("User")
    public String getUser(int Id) {                            // getting the user by id

        try {
            System.out.println("Going to sleep for 5 Secs.. to simulate backend call.");
            Thread.sleep(1000*5);   // add 5 second delay
        } catch (InterruptedException e) {                                      // catch the error
            e.printStackTrace();
        }
        return fakeRepo.findUserById(Id);
    }


    @Override
    public String insertUser(int id, String name, String surname) {
        return null;
    }

    @Override
    public String deleteUser(int Id) {
        return null;
    }

    @Override
    public String findUserById(int Id) {
        return null;
    }
}
