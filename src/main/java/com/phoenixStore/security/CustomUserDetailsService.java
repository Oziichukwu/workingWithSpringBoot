package com.phoenixStore.security;

import com.phoenixStore.data.models.AppUser;
import com.phoenixStore.data.models.Authority;
import com.phoenixStore.data.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findAppUserByEmail(username).orElseThrow(()->
                new UsernameNotFoundException("User with email does not exist"));
        return new User(appUser.getEmail(), appUser.getPassword(),new ArrayList<>());
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Authority> authorities) {
        return authorities.stream().map(authority -> {
            return new SimpleGrantedAuthority(authority.name());
        }).collect(Collectors.toList());
    }


}
