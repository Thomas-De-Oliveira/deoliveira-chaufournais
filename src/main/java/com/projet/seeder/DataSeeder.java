package com.projet.seeder;

import com.projet.dto.AddressDto;
import com.projet.dto.UserDto;
import com.projet.entity.Address;
import com.projet.entity.Users;
import com.projet.mapper.AddressMapper;
import com.projet.mapper.UserMapper;
import com.projet.repository.AddressRepository;
import com.projet.repository.UserRepository;
import com.projet.utils.PasswordUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final UserMapper userMapper;
    private final AddressMapper addressMapper;

    public DataSeeder(UserRepository userRepository, UserMapper userMapper, AddressRepository addressRepository, AddressMapper addressMapper ) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            String password = "mySecretPassword";
            String salt = PasswordUtils.generateSalt();
            String hashedPassword = PasswordUtils.hashPassword(password, salt);

            // Récupérer une adresse existante (par ID ou aléatoirement)
            Long existingAddressId = 1L; // ID de l'adresse existante (à adapter)
            Optional<Address> optionalAddress = addressRepository.findById(existingAddressId);

            if (optionalAddress.isEmpty()) {
                System.out.println("Adresse non trouvée avec l'ID : " + existingAddressId);
                return;
            }

            Address address = optionalAddress.get();
            UserDto user1Dto = new UserDto(null, "Doe", "John", "johndoe", 21, "john.doe@example.com", hashedPassword, salt, address, null);
            UserDto user2Dto = new UserDto(null, "Smith", "Jane", "janesmith", 25, "jane.smith@example.com", hashedPassword, salt, address, null);

            Users user1 = userMapper.toEntity(user1Dto);
            Users user2 = userMapper.toEntity(user2Dto);

            userRepository.save(user1);
            userRepository.save(user2);

            System.out.println("Utilisateurs insérées dans la base de données !");
        }

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
    }
}
