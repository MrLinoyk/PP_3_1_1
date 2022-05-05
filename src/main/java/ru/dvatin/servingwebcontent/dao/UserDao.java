package ru.dvatin.servingwebcontent.dao;

import ru.dvatin.servingwebcontent.models.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUserByID (int id);
    void addUser(User user);
    void removeUser (int id);
    void updateUser (int id, User user);

}
