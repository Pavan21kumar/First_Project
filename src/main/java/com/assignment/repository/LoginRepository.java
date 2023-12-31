package com.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.entity.User;

@Repository
public interface LoginRepository extends JpaRepository<User, Integer> {

}
