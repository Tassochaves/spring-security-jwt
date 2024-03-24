package com.dev.springsecurityjwt.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dev.springsecurityjwt.auth.UserAuth;
import com.dev.springsecurityjwt.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Busca User pelo username, e mapeia para UserAuth (UserDetails)
        return userRepository.findByUsername(username)
            .map(UserAuth::new)
            .orElseThrow(() -> new UsernameNotFoundException("User not found!"));
    }
    
}
