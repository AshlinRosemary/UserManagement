package io.ashlin.restfulwebservices.repository;

import io.ashlin.restfulwebservices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
