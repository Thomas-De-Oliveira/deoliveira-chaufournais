package com.projet.controller;

import com.projet.dto.UserCreationDto;
import com.projet.dto.UserDto;
import com.projet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "5")int size)
    {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(userService.getAllUsers(pageable));
    }

    @PostMapping("/login")
    public UserDto getUserByUsername(@RequestParam String username, @RequestParam String password) throws Exception {
        Optional<UserDto> user = userService.getUserByUsername(username, password);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> save(@RequestBody UserCreationDto userDto) throws Exception {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
