package com.example.Spring.Boot.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Spring.Boot.scheduler.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
