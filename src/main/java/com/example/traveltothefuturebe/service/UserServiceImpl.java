package com.example.traveltothefuturebe.service;

import com.example.traveltothefuturebe.domain.dto.UserDTO;
import com.example.traveltothefuturebe.domain.mapper.UserMapper;
import com.example.traveltothefuturebe.domain.model.User;
import com.example.traveltothefuturebe.repository.UserRepository;
import com.example.traveltothefuturebe.web.request.RequestCreateUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,UserMapper userMapper,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDTO createUser(RequestCreateUser requestCreateUser) {
        User user = User.builder().password(passwordEncoder.encode(requestCreateUser.getPassword()))
                .username(requestCreateUser.getUsername())
                .role(requestCreateUser.getRole()).build();
        User createdUser = userRepository.save(user);
        return userMapper.userToUserDTO(createdUser);
    }

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            }
        };
    }
}
