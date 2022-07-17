package com.maria.users.management.system.conversions;

import com.maria.users.management.system.dtos.UserDto;
import com.maria.users.management.system.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserConvertion {

    public static UserDto entityToDto(User u){
        return new UserDto(u.getUsername(), u.getPassword(), u.getEmail(), u.getFullName());
    }

    public static User dtoToEntity(UserDto userDto){
        return new User(userDto.getUsername(), userDto.getPassword(), userDto.getEmail(), userDto.getFullName());
    }
}
