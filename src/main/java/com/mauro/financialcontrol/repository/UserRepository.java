package com.mauro.financialcontrol.repository;

import com.mauro.financialcontrol.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}