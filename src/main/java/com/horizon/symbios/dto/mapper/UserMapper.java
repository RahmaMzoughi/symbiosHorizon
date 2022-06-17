package com.horizon.symbios.dto.mapper;

import com.horizon.symbios.dto.UserDto;
import com.horizon.symbios.models.User;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto()
                .setEmail(user.getEmail())
                .setUsername(user.getUsername())
                .setPhoneNumber(user.getPhoneNumber());

    }
}
