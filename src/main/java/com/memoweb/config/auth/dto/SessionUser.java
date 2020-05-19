package com.memoweb.config.auth.dto;

import com.memoweb.repository.user.dto.UserDto;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String userId;
    private String roleKey;

    public SessionUser(UserDto userDto) {
        this.userId = userDto.getUserId();
        this.roleKey = userDto.getRoleKey();
    }
}
