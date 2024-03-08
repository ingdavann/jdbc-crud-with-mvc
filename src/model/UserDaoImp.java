package model;

import controller.UserController;
import repository.UserRepository;

import java.util.List;

public class UserDaoImp implements UserDao{

    @Override
    public List<User> createUser() {
        return UserRepository.createUser();
    }

    @Override
    public List<User> getAllUsers() {
        return UserRepository.getAllUsers();
    }

    @Override
    public User searchUserById(Integer id) {
        List<User> user = UserRepository.getAllUsers().stream()
                .filter(e->e.getId().equals(id)).toList();
        return user.get(0);
    }
}
