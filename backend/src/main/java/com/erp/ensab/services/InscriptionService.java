package com.erp.ensab.services;


import com.erp.ensab.dtos.CandidateDTO;
import com.erp.ensab.entities.Candidate;
import com.erp.ensab.exceptions.CandidateAlreadyExistsException;

import java.util.List;

public interface InscriptionService {

    boolean saveCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException;
    List<Candidate> getAllCandidates();
}
