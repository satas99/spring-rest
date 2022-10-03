package com.example.restdemo.repository;

import com.example.restdemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository provides JPA related methods such as flushing the persistence context and delete records in a batch.
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
