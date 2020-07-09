package org.thingsboard.server.dto;

import lombok.Data;
import org.thingsboard.server.common.data.User;
import org.thingsboard.server.common.data.id.UserId;

@Data
public class UserDto {

    private String id;
    private String email;
    private String password;
    private String userName;

    public static UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setUserName(user.getFirstName());
        userDto.setId(user.getId().toString());
        return userDto;
    }

    public User mapToUser(){
        User user = new User();
        user.setFirstName(userName);
        user.setEmail(email);
        if(id != null)
            user.setId(UserId.fromString(id));

        return user;
    }
}
