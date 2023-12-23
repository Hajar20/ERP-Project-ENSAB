package com.erp.ensab.services;


import com.erp.ensab.dtos.CandidateDTO;
import com.erp.ensab.exceptions.CandidateAlreadyExistsException;

public interface InscriptionService {

    boolean saveCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException;
}
