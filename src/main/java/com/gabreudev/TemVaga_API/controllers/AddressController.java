package com.gabreudev.TemVaga_API.controllers;

import com.gabreudev.TemVaga_API.entities.address.AddressDTO;
import com.gabreudev.TemVaga_API.entities.address.CreateAddressDTO;
import com.gabreudev.TemVaga_API.servecies.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestBody CreateAddressDTO dto) {
        AddressDTO address = addressService.createAddress(dto);
        return ResponseEntity.ok(address);
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAllAddresses() {
        List<AddressDTO> addresses = addressService.getAllAddresses();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable UUID id) {
        AddressDTO address = addressService.getAddressById(id);
        return ResponseEntity.ok(address);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddress(@PathVariable UUID id) {
        addressService.deleteAddress(id);
        return ResponseEntity.noContent().build();
    }
}
