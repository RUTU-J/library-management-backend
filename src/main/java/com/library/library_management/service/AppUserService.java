package com.library.library_management.service;

import com.library.library_management.DTO.UserDto;
import com.library.library_management.entity.AppUser;
import com.library.library_management.repository.AppUserRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService {

    private final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    // CREATE USER
    public UserDto createUser(AppUser user) {
        AppUser saved=appUserRepo.save(user);
        UserDto userDto=new UserDto();
        userDto.setId(saved.getId());
        userDto.setName(saved.getName());
        userDto.setEmail(saved.getEmail());

        return userDto;
    }

    // GET ALL USERS
    public List<UserDto> getAllUsers() {
        List<UserDto> dtoList = new ArrayList<>();

        List<AppUser> users = appUserRepo.findAll();

        for (AppUser user : users) {
            UserDto dto = new UserDto();
            dto.setId(user.getId());
            dto.setName(user.getName());
            dto.setEmail(user.getEmail());

            dtoList.add(dto);
        }

        return dtoList;
    }

    // UPDATE USER
    public UserDto updateUser(Long id, AppUser user) {
        AppUser present = appUserRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        present.setName(user.getName());
        present.setEmail(user.getEmail());

        AppUser updated = appUserRepo.save(present);

        UserDto dto = new UserDto();
        dto.setId(updated.getId());
        dto.setName(updated.getName());
        dto.setEmail(updated.getEmail());

        return dto;
    }

    // DELETE USER
    public void deleteUser(Long id) {
        AppUser user = appUserRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        appUserRepo.delete(user);
    }
}
