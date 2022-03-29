package com.phoenixStore.web.controller;


import com.phoenixStore.data.dto.AppUserDto;
import com.phoenixStore.data.dto.AppUserResponseDto;
import com.phoenixStore.service.appUser.AppUserService;
import com.phoenixStore.service.email.EmailUtil;
import com.phoenixStore.web.exception.BusinessLogicException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/appUser")
@RestController
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private EmailUtil emailUtil;

    @PostMapping()
    public ResponseEntity<?>register(@RequestBody AppUserDto appUserDto){

        try{
            AppUserResponseDto responseDto = appUserService.register(appUserDto);
            emailUtil.sendEmail("oziichukwu1@gmail.com", "Location saved", "Location saved successfully");

            return ResponseEntity.ok().body(responseDto);
        }catch (BusinessLogicException e){
            return ResponseEntity.badRequest().body(e);
        }
    }

}
