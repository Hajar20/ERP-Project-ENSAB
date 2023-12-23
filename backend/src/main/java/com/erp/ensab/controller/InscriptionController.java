package com.erp.ensab.controller;

import com.erp.ensab.dtos.CandidateDTO;
import com.erp.ensab.exceptions.CandidateAlreadyExistsException;
import com.erp.ensab.services.InscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/system/api/")
@AllArgsConstructor

public class InscriptionController {

    private final InscriptionService inscriptionService;
    @PostMapping("/inscription")
    public ResponseEntity<String> registerCandidate(@RequestBody CandidateDTO candidateDTO)  throws CandidateAlreadyExistsException {
        boolean isSaved = inscriptionService.saveCandidate(candidateDTO);
            return ResponseEntity.ok("Candidate registered successfully.");
    }
}
