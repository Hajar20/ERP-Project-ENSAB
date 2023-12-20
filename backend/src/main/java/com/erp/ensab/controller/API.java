package com.erp.ensab.controller;

import com.erp.ensab.entities.*;
import com.erp.ensab.payload.request.LoginRequest;
import com.erp.ensab.payload.request.SignupRequest;
import com.erp.ensab.payload.response.JwtResponse;
import com.erp.ensab.payload.response.MessageResponse;
import com.erp.ensab.repository.*;
import com.erp.ensab.repository.ResponsableRepository;
import com.erp.ensab.security.jwt.JwtUtils;
import com.erp.ensab.security.services.UserDetailsImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/system/api")
public class API {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ResponsableRepository responsableRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (responsableRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }

        // Create new user's account
        Responsable user = new Responsable(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getUsername());


        responsableRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail()));
    }

/*
*  JUST FOR TEST !!!!!
    @Autowired
    private MajorRepository majorRepository;


    @PostMapping ("/add")
    public Major addMajor(@RequestBody Major major){
        major.setID(UUID.randomUUID().toString().split("-")[0]);
        System.out.println("Major :"+major);
        return majorRepository.save(major);
    }

    @GetMapping("/all")
    public List<Major> getAllMajors(){
        return majorRepository.findAll();
    }
* */
}

