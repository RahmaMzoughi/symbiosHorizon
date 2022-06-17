package com.horizon.symbios.services;

import com.horizon.symbios.dto.UserDto;
import com.horizon.symbios.dto.mapper.UserMapper;
import com.horizon.symbios.models.User;
import com.horizon.symbios.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;


    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto findUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        if (user.isPresent()) {
            return userMapper.map(user.get(), UserDto.class);
        }
        throw exception(USER, ENTITY_NOT_FOUND, email);
    }

    @Override
    public UserDto updateProfile(UserDto userDto) {
        return null;
    }
}
