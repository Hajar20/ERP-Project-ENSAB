package com.erp.ensab.controller;

import com.erp.ensab.dtos.CandidateDTO;
import com.erp.ensab.entities.Candidate;
import com.erp.ensab.exceptions.CandidateAlreadyExistsException;
import com.erp.ensab.services.InscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/system/api/")
@AllArgsConstructor

public class InscriptionController {

    private final InscriptionService inscriptionService;
    @PostMapping("/inscription")
    public ResponseEntity<Map<String, String>> registerCandidate(@RequestBody CandidateDTO candidateDTO)  throws CandidateAlreadyExistsException {
        boolean isSaved = inscriptionService.saveCandidate(candidateDTO);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Candidate registered successfully.");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/getAllCandidates")
    public ResponseEntity<List<Candidate>> getCandidates() {
        List<Candidate> candidates = inscriptionService.getAllCandidates();
        return ResponseEntity.ok(candidates);
    }
}
