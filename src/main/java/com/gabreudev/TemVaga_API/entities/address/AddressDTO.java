package com.gabreudev.TemVaga_API.entities.address;

import java.util.UUID;

public record AddressDTO(
        UUID id,
        String street,
        String number,
        String complement,
        String neighborhood,
        String city,
        String state,
        UUID userId
) {
}

