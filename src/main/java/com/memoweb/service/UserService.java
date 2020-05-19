package com.memoweb.service;

import com.memoweb.repository.user.Role;
import com.memoweb.repository.user.UserEntity;
import com.memoweb.repository.user.UserRepository;
import com.memoweb.repository.user.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final HttpSession session;

    @Transactional
    public Long addUser(UserDto userDto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        userDto.setUserPassword(bCryptPasswordEncoder.encode(userDto.getUserPassword()));
        userDto.setRole(Role.ADMIN);

        return userRepository.save(userDto.toEntity()).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<UserEntity> userWrapper = userRepository.findByUserId(userId);
        UserEntity userEntity = userWrapper.orElseThrow(()->new UsernameNotFoundException("User Not Found : " + userId));

        session.setAttribute("user", new UserDto(userEntity));
        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(userEntity.getRole().getKey()));

        return new User(userEntity.getUserId(), userEntity.getUserPassword(), authorityList);
    }
}
