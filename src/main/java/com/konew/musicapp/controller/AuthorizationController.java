package com.konew.musicapp.controller;

import com.konew.musicapp.model.LoginModel;
import com.konew.musicapp.model.RegisterModel;
import com.konew.musicapp.security.jwt.UserResponse;
import com.konew.musicapp.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthorizationController {
    AuthorizationService authorizationService;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> userLogin(@Valid @RequestBody LoginModel loginModel) {
        return authorizationService.userLogin(loginModel);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@Valid @RequestBody RegisterModel registerModel) {
        return authorizationService.register(registerModel);
    }

}
