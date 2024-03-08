package model;

import java.util.List;

public interface UserDao {
    List<User> createUser();
    List<User> getAllUsers();
    User searchUserById(Integer id);
}
