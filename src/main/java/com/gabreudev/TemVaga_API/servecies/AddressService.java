package com.gabreudev.TemVaga_API.servecies;


import com.gabreudev.TemVaga_API.entities.User;
import com.gabreudev.TemVaga_API.entities.address.Address;
import com.gabreudev.TemVaga_API.entities.address.AddressDTO;
import com.gabreudev.TemVaga_API.entities.address.CreateAddressDTO;
import com.gabreudev.TemVaga_API.repositories.AddressRepository;
import com.gabreudev.TemVaga_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public com.gabreudev.TemVaga_API.entities.address.AddressDTO createAddress(CreateAddressDTO dto) {
        User user = userRepository.findById(dto.userId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Address address = new Address();
        address.setStreet(dto.street());
        address.setNumber(dto.number());
        address.setComplement(dto.complement());
        address.setNeighborhood(dto.neighborhood());
        address.setCity(dto.city());
        address.setState(dto.state());
        address.setUser(user);

        addressRepository.save(address);

        return new AddressDTO(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                user.getId()
        );
    }

    @Transactional(readOnly = true)
    public List<AddressDTO> getAllAddresses() {
        return addressRepository.findAll().stream()
                .map(address -> new AddressDTO(
                        address.getId(),
                        address.getStreet(),
                        address.getNumber(),
                        address.getComplement(),
                        address.getNeighborhood(),
                        address.getCity(),
                        address.getState(),
                        address.getUser().getId()
                ))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AddressDTO getAddressById(UUID id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));
        return new AddressDTO(
                address.getId(),
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getNeighborhood(),
                address.getCity(),
                address.getState(),
                address.getUser().getId()
        );
    }

    @Transactional
    public void deleteAddress(UUID id) {
        addressRepository.deleteById(id);
    }
}
