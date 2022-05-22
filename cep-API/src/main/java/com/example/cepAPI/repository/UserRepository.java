package com.example.cepAPI.repository;

import com.example.cepAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    User findByCep(String cep);

}
