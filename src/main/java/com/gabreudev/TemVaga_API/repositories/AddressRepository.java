package com.gabreudev.TemVaga_API.repositories;

import com.gabreudev.TemVaga_API.entities.address.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
}
