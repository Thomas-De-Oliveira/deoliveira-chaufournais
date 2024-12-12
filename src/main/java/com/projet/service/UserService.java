package com.projet.service;

import com.projet.dto.UserCreationDto;
import com.projet.dto.UserDto;
import com.projet.entity.Address;
import com.projet.entity.Users;
import com.projet.exception.RessourceNotFoundException;
import com.projet.mapper.TypePartyMapper;
import com.projet.mapper.UserMapper;
import com.projet.repository.AddressRepository;
import com.projet.repository.UserRepository;
import com.projet.utils.PasswordUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final TypePartyMapper typePartyMapper;
    private final AddressRepository addressRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper, TypePartyMapper typePartyMapper, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.typePartyMapper = typePartyMapper;
        this.addressRepository = addressRepository;
    }

    public UserDto createUser(UserCreationDto userCreationDto) throws Exception {
        String salt = PasswordUtils.generateSalt();
        String passwordHash = PasswordUtils.hashPassword(userCreationDto.getPassword(), salt);

        Address address = addressRepository.findById(userCreationDto.getAddressId())
                .orElseThrow(() -> new RuntimeException("Address not found"));

        UserDto userDto = new UserDto();
        userDto.setFamilyName(userCreationDto.getFamilyName());
        userDto.setName(userCreationDto.getName());
        userDto.setUsername(userCreationDto.getUsername());
        userDto.setAge(userCreationDto.getAge());
        userDto.setEmail(userCreationDto.getEmail());
        userDto.setPasswordHash(passwordHash);
        userDto.setPasswordSalt(salt);
        userDto.setAddress(address);
        userDto.setTypeParties(userCreationDto.getTypeParties());

        Users user = userMapper.toEntity(userDto);
        Users savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    public List<UserDto> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto).getContent();

    }

    public UserDto getUserById(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        return userMapper.toDto(user);
    }

    public Optional<UserDto> getUserByUsername(String username, String password) throws Exception {
        Optional<Users> optionalUser = userRepository.findUserByUsername(username);

        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            // Verify password
            boolean isPasswordValid = PasswordUtils.verifyPassword(password, user.getPasswordSalt(), user.getPasswordHash());
            if (isPasswordValid) {
                return Optional.of(userMapper.toDto(user));
            }
        }

        return Optional.empty();
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        Users existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id));

        // Mise à jour des champs
        existingUser.setFamilyName(userDto.getFamilyName());
        existingUser.setName(userDto.getName());
        existingUser.setUsername(userDto.getUsername());
        existingUser.setEmail(userDto.getEmail());
        existingUser.setPasswordHash(userDto.getPasswordHash());
        existingUser.setPasswordSalt(userDto.getPasswordSalt());

        // Mise à jour des intérêts (typeParties)
        existingUser.setTypeParties(
                userDto.getTypeParties() != null ?
                        userDto.getTypeParties().stream()
                                .map(typePartyDto -> typePartyMapper.toEntity(typePartyDto))
                                .collect(Collectors.toSet()) :
                        existingUser.getTypeParties()
        );

        Users updatedUser = userRepository.save(existingUser);
        return userMapper.toDto(updatedUser);
    }

    // Méthode pour supprimer un utilisateur par son ID
    public void deleteUser(Long id) {
        Users user = userRepository.findById(id)
                .orElseThrow(() -> new RessourceNotFoundException("Utilisateur non trouvé avec l'ID : " + id));
        userRepository.delete(user);
    }
}
