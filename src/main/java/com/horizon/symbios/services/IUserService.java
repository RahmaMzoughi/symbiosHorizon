package com.horizon.symbios.services;

import com.horizon.symbios.dto.UserDto;

public interface IUserService {

    UserDto findUserByEmail(String email);
    UserDto updateProfile(UserDto userDto);
}
