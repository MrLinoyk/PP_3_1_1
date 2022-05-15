package ru.dvatin.servingwebcontent.servicies;

import org.springframework.stereotype.Service;
import ru.dvatin.servingwebcontent.models.User;
import ru.dvatin.servingwebcontent.repositories.UserRepository;

@Service
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void removeUser(int id) {
        userRepository.deleteById(id);

    }

    @Override
    public void updateUser(int id) {
        userRepository.save(getUserById(id));
    }
}
