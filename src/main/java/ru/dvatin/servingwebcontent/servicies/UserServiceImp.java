package ru.dvatin.servingwebcontent.servicies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dvatin.servingwebcontent.dao.UserDao;
import ru.dvatin.servingwebcontent.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService{
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserByID(int id) {
        return userDao.getUserByID(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);

    }

    @Override
    public void removeUser(int id) {
        userDao.removeUser(id);

    }

    @Override
    public void updateUser(int id, User user) {
        userDao.updateUser(id, user);

    }
}
