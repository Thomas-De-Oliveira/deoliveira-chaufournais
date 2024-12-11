package com.projet.service;

import com.projet.dto.AddressDto;
import com.projet.entity.Address;
import com.projet.exception.RessourceNotFoundException;
import com.projet.mapper.AddressMapper;
import com.projet.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    public AddressDto createAddress(AddressDto addressDto) {
        Address address = addressMapper.toEntity(addressDto);
        Address savedAddress = addressRepository.save(address);
        return addressMapper.toDto(savedAddress);
    }

    public List<AddressDto> getAllAddresses(Pageable pageable) {
        return addressRepository.findAll(pageable)
                .map(addressMapper::toDto)
                .getContent();
    }

    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Adresse non trouvée avec l'ID : " + id));
        return addressMapper.toDto(address);
    }

    public AddressDto updateAddress(Long id, AddressDto addressDto) {
        Address existingAddress = addressRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Adresse non trouvée avec l'ID : " + id));

        existingAddress.setCity(addressDto.getCity());
        existingAddress.setCountry(addressDto.getCountry());

        Address updatedAddress = addressRepository.save(existingAddress);
        return addressMapper.toDto(updatedAddress);
    }

    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Adresse non trouvée avec l'ID : " + id));
        addressRepository.delete(address);
    }
}
