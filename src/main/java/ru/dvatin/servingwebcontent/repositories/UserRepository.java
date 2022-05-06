package ru.dvatin.servingwebcontent.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import ru.dvatin.servingwebcontent.models.User;

public interface UserRepository extends JpaRepository <User, Integer> {
}
