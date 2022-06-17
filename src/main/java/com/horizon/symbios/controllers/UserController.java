package com.horizon.symbios.controllers;

import com.horizon.symbios.models.User;
import com.horizon.symbios.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private IUserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId)
            throws Exception {
        User User = userRepository.findById(UserId)
                .orElseThrow(() -> new Exception("User not found for this id :: " + UserId));
        return ResponseEntity.ok().body(User);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                           @Validated @RequestBody User userDetails) throws Exception {

        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("not found !!!!!!!!!"));
        user.setEmail(userDetails.getEmail());
        user.setUsername(userDetails.getEmail());
        user.setPhoneNumber(userDetails.getPhoneNumber());

        final User updatedUser = userRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("not deleted .§§§§§§§§"));
        userRepository.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
