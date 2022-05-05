package ru.dvatin.servingwebcontent.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.dvatin.servingwebcontent.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
