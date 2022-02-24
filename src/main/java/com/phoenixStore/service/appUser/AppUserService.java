package com.phoenixStore.service.appUser;

import com.phoenixStore.data.dto.AppUserDto;
import com.phoenixStore.data.dto.AppUserResponseDto;

public interface AppUserService {

    AppUserResponseDto register(AppUserDto appUserDto);
}
