package ru.dvatin.servingwebcontent.servicies;

import ru.dvatin.servingwebcontent.models.User;

public interface UserService {
    Iterable<User> getAllUsers ();
    User getUserById (int id);
    void addUser (User user);
    void removeUser (int id);
    void updateUser (int id);
}
