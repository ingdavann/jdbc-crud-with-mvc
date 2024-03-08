package controller;

import model.User;
import model.UserDao;
import model.UserDaoImp;

import java.util.List;

public class UserController {
    private final UserDao userDao = new UserDaoImp();
    public List<User> createUser(){
        return userDao.createUser();
    }
    public List<User> getAllUsers(){
        return  userDao.getAllUsers();
    }
    public User searchById(Integer id) {
        User search = null;
        try {
            search = userDao.searchUserById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return search;
    }
}
