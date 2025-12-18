package com.library.library_management.controller;

import com.library.library_management.DTO.UserDto;
import com.library.library_management.entity.AppUser;
import com.library.library_management.service.AppUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    // CREATE USER
    @PostMapping
    public UserDto createUser(@RequestBody AppUser user) {
        return appUserService.createUser(user);
    }

    // GET ALL USERS
    @GetMapping
    public List<UserDto> getAllUsers() {
        return appUserService.getAllUsers();
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody AppUser user) {
        return appUserService.updateUser(id, user);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        appUserService.deleteUser(id);
        return "User deleted successfully";
    }
}
