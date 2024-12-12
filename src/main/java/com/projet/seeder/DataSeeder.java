package com.projet.seeder;

import com.projet.dto.AddressDto;
import com.projet.dto.UserCreationDto;
import com.projet.entity.Address;
import com.projet.entity.Users;
import com.projet.mapper.AddressMapper;
import com.projet.mapper.UserMapper;
import com.projet.repository.UserRepository;
import com.projet.service.UserService;
import com.projet.repository.AddressRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserService userService;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    public DataSeeder(UserService userService, AddressRepository addressRepository, UserMapper userMapper, AddressMapper addressMapper, UserRepository userRepository) {
        this.userService = userService;
        this.addressRepository = addressRepository;
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Si les adresses n'existent pas encore dans la base de données
        if (addressRepository.count() == 0) {
            AddressDto address1Dto = new AddressDto(null, "Paris", "France");
            AddressDto address2Dto = new AddressDto(null, "Lyon", "France");
            AddressDto address3Dto = new AddressDto(null, "Nice", "France");
            AddressDto address4Dto = new AddressDto(null, "Marseille", "France");
            AddressDto address5Dto = new AddressDto(null, "Monaco", "France");
            AddressDto address6Dto = new AddressDto(null, "Strasbourg", "France");

            Address address1 = addressMapper.toEntity(address1Dto);
            Address address2 = addressMapper.toEntity(address2Dto);
            Address address3 = addressMapper.toEntity(address3Dto);
            Address address4 = addressMapper.toEntity(address4Dto);
            Address address5 = addressMapper.toEntity(address5Dto);
            Address address6 = addressMapper.toEntity(address6Dto);

            addressRepository.save(address1);
            addressRepository.save(address2);
            addressRepository.save(address3);
            addressRepository.save(address4);
            addressRepository.save(address5);
            addressRepository.save(address6);

            System.out.println("Adresses insérées dans la base de données !");
        }

        // Si les utilisateurs n'existent pas encore et qu'il y a des adresses
        if (userRepository.count() == 0 && addressRepository.count() > 0) {
            UserCreationDto user1Dto = new UserCreationDto(null, "Doe", "John", "johndoe", 21, "john.doe@example.com", "testBlabla", 1L, null);
            UserCreationDto user2Dto = new UserCreationDto(null, "Smith", "Jane", "janesmith", 25, "jane.smith@example.com", "testBleuBleu", 2L, null);

            // Utilisation de UserService pour enregistrer les utilisateurs
            userService.createUser(user1Dto);
            userService.createUser(user2Dto);

            System.out.println("Utilisateurs insérés dans la base de données !");
        }
    }
}
