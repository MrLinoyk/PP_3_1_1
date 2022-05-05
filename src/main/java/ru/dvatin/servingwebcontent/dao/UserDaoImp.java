package ru.dvatin.servingwebcontent.dao;

import org.springframework.stereotype.Repository;
import ru.dvatin.servingwebcontent.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao{
    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager () {
        return this.manager;
    }

    @Override
    public List<User> getAllUsers() {
        return getManager().createQuery("SELECT u from User u", User.class).getResultList();
    }

    @Override
    public User getUserByID(int id) {
        return getManager().find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        getManager().persist(user);

    }

    @Override
    public void removeUser(int id) {
        getManager().remove(getUserByID(id));

    }

    @Override
    public void updateUser(int id, User user) {
        getManager().merge(user);

    }
}
