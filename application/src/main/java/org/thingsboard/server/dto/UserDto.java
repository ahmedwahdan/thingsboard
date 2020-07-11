/**
 * Copyright © 2016-2020 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
