package com.mariem.TP_API_REST.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.mariem.TP_API_REST.repository.AppUserRepository;
import com.mariem.TP_API_REST.repository.RoleRepository;
import com.mariem.TP_API_REST.entity.AppUser;
import com.mariem.TP_API_REST.entity.Role;
import java.util.List;

@Service
public class UserServiceImpl {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> addUser(AppUser userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        Role roleUse = roleRepository.findById(2).get();
        userInfo.setRole(roleUse);
        appUserRepository.save(userInfo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    public AppUser fidUserByUsername(String username) {
        return appUserRepository.findByUsername(username).get();
    }

    public void DeleteUser(Integer id) {
        appUserRepository.deleteById(id);
    }

    public boolean findUserById(Integer id) {
        if (appUserRepository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public AppUser getUserById(Integer id) {
        if (appUserRepository.findById(id).isPresent()) {
            return appUserRepository.findById(id).get();
        }
        return null;
    }
}