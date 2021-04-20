package com.konew.musicapp.service;

import com.konew.musicapp.entity.Role;
import com.konew.musicapp.entity.RoleEnum;
import com.konew.musicapp.entity.User;
import com.konew.musicapp.model.LoginModel;
import com.konew.musicapp.model.RegisterModel;
import com.konew.musicapp.repository.RoleRepository;
import com.konew.musicapp.repository.UserRepository;
import com.konew.musicapp.security.jwt.TokenCreater;
import com.konew.musicapp.security.jwt.UserResponse;
import com.konew.musicapp.security.userDetails.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorizationService
{
    TokenCreater tokenCreater;
    AuthenticationManager authenticationManager;
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    RoleRepository roleRepository;

    @Autowired
    public AuthorizationService(TokenCreater tokenCreater, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
                                UserRepository userRepository, RoleRepository roleRepository) {
        this.tokenCreater = tokenCreater;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public ResponseEntity<UserResponse> userLogin(LoginModel loginModel){

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginModel.getUsername(), loginModel.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = tokenCreater.createToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(x -> x.getAuthority())
                .collect(Collectors.toList());


        return ResponseEntity.ok(new UserResponse(token,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    public ResponseEntity<?> register(RegisterModel registerModel){
        if(userRepository.existsByUsername(registerModel.getUsername())){
            return ResponseEntity.badRequest().body("Error: Username is already taken!");
        }
        if(userRepository.existsByEmail(registerModel.getEmail())){
            return ResponseEntity.badRequest().body("Error: Email is already taken!");
        }
        User user = new User();
        user.setUsername(registerModel.getUsername());
        user.setEmail(registerModel.getEmail());
        user.setPassword(passwordEncoder.encode(registerModel.getPassword()));

        Role role = roleRepository.findByName(RoleEnum.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        List<Role>roles = new ArrayList<>();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok("User are successfully registered");
    }
}
