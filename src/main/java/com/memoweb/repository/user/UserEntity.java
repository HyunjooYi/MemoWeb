package com.memoweb.repository.user;

import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public UserEntity(String userId, String userPassword, Role role) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
