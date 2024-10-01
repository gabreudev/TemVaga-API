package com.gabreudev.TemVaga_API.entities.address;


import java.util.UUID;

public record CreateAddressDTO(
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        UUID userId
) {
}
