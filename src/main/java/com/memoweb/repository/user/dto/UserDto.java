package com.memoweb.repository.user.dto;

import com.memoweb.repository.user.Role;
import com.memoweb.repository.user.UserEntity;
import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class UserDto {
    private String userId;
    private String userPassword;
    private Role role;

    @Builder
    public UserDto(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.role = Role.ADMIN;
    }

    @Builder
    public UserDto(UserEntity entity) {
        this.userId = entity.getUserId();
        this.userPassword = entity.getUserPassword();
        this.role = entity.getRole();
    }

    public UserEntity toEntity() {
        return new UserEntity(this.userId, this.userPassword, this.role);
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
