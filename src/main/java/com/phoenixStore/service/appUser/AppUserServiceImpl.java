package com.phoenixStore.service.appUser;

import com.phoenixStore.data.dto.AppUserDto;
import com.phoenixStore.data.dto.AppUserResponseDto;
import com.phoenixStore.data.models.AppUser;
import com.phoenixStore.data.repository.AppUserRepository;
import com.phoenixStore.service.email.EmailUtil;
import com.phoenixStore.web.exception.UserAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class AppUserServiceImpl implements AppUserService{

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailUtil emailUtil;

    @Override
    public AppUserResponseDto register(AppUserDto appUserDto) {

        if (appUserRepository.existsByEmail(appUserDto.getEmail())){
              throw new UserAlreadyExistException("User with email already exist");
        }

        AppUser appUser = new AppUser();
        appUser.setFirstName(appUserDto.getFirstName());
        appUser.setLastName(appUserDto.getLastName());
        appUser.setEmail(appUserDto.getEmail());
        appUser.setPassword(passwordEncoder.encode(appUserDto.getPassword()));
        appUser.setAddress(appUserDto.getAddress());

       emailUtil.sendEmail("oziichukwu1@gmail.com", "Location saved", "Location saved successfully");

        appUserRepository.save(appUser);


        return buildUserResponse(appUser);
    }

    private AppUserResponseDto buildUserResponse(AppUser appUser){
        return  AppUserResponseDto.builder()
                .firstName(appUser.getFirstName())
                .lastName(appUser.getLastName())
                .email(appUser.getEmail())
                .address(appUser.getAddress())
                .build();
    }
}
