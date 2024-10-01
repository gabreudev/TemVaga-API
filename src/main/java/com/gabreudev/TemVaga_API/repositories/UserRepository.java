package com.gabreudev.TemVaga_API.repositories;

import com.gabreudev.TemVaga_API.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
