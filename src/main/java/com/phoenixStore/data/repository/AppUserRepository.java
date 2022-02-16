package com.phoenixStore.data.repository;

import com.phoenixStore.data.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {


}
