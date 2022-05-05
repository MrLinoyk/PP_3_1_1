package ru.dvatin.servingwebcontent.servicies;

import ru.dvatin.servingwebcontent.models.User;

import java.util.List;

public interface UserService {
    List <User> getAllUsers();
    User getUserByID(int id);
    void addUser(User user);
    void removeUser(int id);
    void updateUser (int id, User user);
}
