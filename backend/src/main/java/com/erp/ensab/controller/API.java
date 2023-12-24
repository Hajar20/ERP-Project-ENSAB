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

import java.util.*;
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
    CriteriaRepository criteriaRepository;

    @Autowired
    PostRepository postRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    //handling posts
    @GetMapping("/getAllPosts/{id}")
    public Post getPost(@PathVariable String id){
        return postRepository.findById(id).get();
    }
    @GetMapping("/getAllPosts")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
    @PostMapping("/addPost/{id}")
    public ResponseEntity<Post> savePosts(@RequestBody Post post, @PathVariable String id){
        Responsable res = responsableRepository.findById(id).get();
        post.setResponsable(res);

        return  ResponseEntity.ok(postRepository.save(post));
    }
    //Manipulating a criteria
    @PostMapping("/addCriteria/{id}")
    public ResponseEntity<Criteria> saveCriteria(@RequestBody Criteria criteria,@PathVariable String id){

        Responsable res = responsableRepository.findById(id).get();
        criteria.setResponsable(res);

        return ResponseEntity.ok(criteriaRepository.save(criteria));
    }
    @PutMapping("/updateCriteria/{id}")
    public ResponseEntity<Criteria> updateCriteria(@RequestBody Criteria newC,@PathVariable String id){
        Criteria c = criteriaRepository.findById(id).get();
        c.setLink(newC.getLink());
        c.setDetails(newC.getDetails());
        c.setEndDate(newC.getEndDate());
        c.setStartDate(newC.getStartDate());
        c.setMajorPlaces(newC.getMajorPlaces());
        c.setThreshold2(newC.getThreshold2());
        c.setThreshold3(newC.getThreshold3());
        c.setThreshold1(newC.getThreshold1());
        Criteria updatedC = criteriaRepository.save(c);

        return ResponseEntity.ok(updatedC);
    }
    @GetMapping("/getAllCriteria")
    public List<Criteria> getAllCriteria() {
        return criteriaRepository.findAll();
    }
    @GetMapping("/getCriteriaByResp/{id}")
    public  Criteria getCriteriaByResp(@PathVariable String id){
        return criteriaRepository.findCriteriaByResponsableID(id);
    }

    @GetMapping("/getCriteriaByDate")
    public  Criteria getCriteriaByResp(){
        Criteria  criteria = criteriaRepository.findCriteriaByYear(new Date().getYear()+1900);
        return criteria;
    }

    @GetMapping("/getCriteria/{id}")
    public  Criteria getCriteria(@PathVariable String id){
        return criteriaRepository.findById(id).get();
    }
    @DeleteMapping("/removeCriteria/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCriteria(@PathVariable String id){
        Criteria c = criteriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("CriteriaNotFoundException"));
        criteriaRepository.delete(c);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Criteria deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/removeAllCriteria")
    public ResponseEntity<Map<String, Boolean>> deleteAllCriteria(){

        criteriaRepository.deleteAll();
        Map<String, Boolean> response = new HashMap<>();
        response.put("Criterias deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    //-----------------------------------------------------------------------
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

