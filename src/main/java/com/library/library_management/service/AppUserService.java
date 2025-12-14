package com.library.library_management.service;

import com.library.library_management.entity.AppUser;
import com.library.library_management.repository.AppUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    // CREATE USER
    public AppUser createUser(AppUser user) {
        return appUserRepo.save(user);
    }

    // GET ALL USERS
    public List<AppUser> getAllUsers() {
        return appUserRepo.findAll();
    }

    // UPDATE USER
    public AppUser updateUser(Long id, AppUser user) {
        AppUser present = appUserRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        present.setName(user.getName());
        present.setEmail(user.getEmail());

        return appUserRepo.save(present);
    }

    // DELETE USER
    public void deleteUser(Long id) {
        AppUser user = appUserRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        appUserRepo.delete(user);
    }
}
