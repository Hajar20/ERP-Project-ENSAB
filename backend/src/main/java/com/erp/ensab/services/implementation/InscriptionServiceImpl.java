package com.erp.ensab.services.implementation;

import com.erp.ensab.dtos.CandidateDTO;
import com.erp.ensab.dtos.DegreeDTO;
import com.erp.ensab.entities.Bac;
import com.erp.ensab.entities.Candidate;
import com.erp.ensab.entities.Degree;
import com.erp.ensab.entities.Major;
import com.erp.ensab.exceptions.CandidateAlreadyExistsException;
import com.erp.ensab.mapper.BacMapper;
import com.erp.ensab.mapper.CandidateMapper;
import com.erp.ensab.mapper.DegreeMapper;
import com.erp.ensab.mapper.MajorMapper;
import com.erp.ensab.repository.BacRepository;
import com.erp.ensab.repository.CandidateRepository;
import com.erp.ensab.repository.DegreeRepository;
import com.erp.ensab.repository.MajorRepository;
import com.erp.ensab.services.InscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InscriptionServiceImpl implements InscriptionService {


    private final CandidateRepository candidateRepository;
    private final MajorRepository majorRepository;
    private final DegreeRepository degreeRepository;
    private final BacRepository bacRepository;

    @Override
    public boolean  saveCandidate(CandidateDTO candidateDTO) throws CandidateAlreadyExistsException {
        if ( candidateRepository.existsByCne(candidateDTO.getCne()) ){
            throw  new CandidateAlreadyExistsException("the candidate already exist");
        }
         Candidate candidate = CandidateMapper.mapToCandidate(candidateDTO);

     if ( isCandidateEligible(candidateDTO)){

         List<DegreeDTO> degreeDTOList = candidateDTO.getDegrees();
         List<Degree> degrees = degreeRepository.saveAll(DegreeMapper.mapToDegrees(degreeDTOList));
         Major major = majorRepository.save(MajorMapper.mapToMajor(candidateDTO.getMajor()));
         Bac bac = bacRepository.save(BacMapper.mapToBac(candidateDTO.getBac()));

         Candidate candidate1 = Candidate.builder()
                 .firstname(candidate.getFirstname())
                 .lastname(candidate.getLastname())
                 .cne(candidate.getCne())
                 .cni(candidate.getCni())
                 .phone(candidate.getPhone())
                 .sexe(candidate.getSexe())
                 .degrees(degrees)
                 .major(major)
                 .birthdate(candidate.getBirthdate())
                 .bac(bac)
                 .build();
         candidateRepository.save(candidate1);
         return true;
     }
        return false;
    }

    private boolean isCandidateEligible(CandidateDTO candidate) {
        if (candidate.getBac() != null) {
            if (isBachelorEligible(candidate)) {
                if (candidate.getDegrees() != null && !candidate.getDegrees().isEmpty()) {
                    for (DegreeDTO degree : candidate.getDegrees()) {
                        if (isDegreeEligible(degree)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private boolean isBachelorEligible(CandidateDTO candidate) {
        Candidate candidat = CandidateMapper.mapToCandidate(candidate);
        Date bacDate = candidat.getBac().getDateObtaining();

        if (candidate.getDegrees() != null && !candidate.getDegrees().isEmpty()) {
            for (DegreeDTO degree : candidate.getDegrees()) {
                Degree degree1 = DegreeMapper.mapToDegree(degree);
                if ("Bac+2".equals(degree.getDegreeType()) || "Bac+3".equals(degree.getDegreeType())) {
                    Date diplomaDate = degree1.getDiplomaDate();
                    long maxDiplomaDuration = 3 * 365 * 24 * 60 * 60 * 1000L + ( 30 * 24 * 60 * 60 * 1000L);  // Maximum duration is 3 years for the diploma

                    log.info("Bac Date (milliseconds): " + bacDate.getTime());
                    log.info("Diploma Date (milliseconds): " + diplomaDate.getTime());
                    log.info("Maximum duration (milliseconds):"+ maxDiplomaDuration);

                    // Check if the duration between Bac and Diploma is within the allowed limit
                    if (diplomaDate != null && (diplomaDate.getTime() - bacDate.getTime()) <= maxDiplomaDuration) {
                        log.info("Eligible");
                        return true;
                    }
                }
            }
        }
        return false;
    }



    private boolean isDegreeEligible(DegreeDTO degree) {
        if ("DUT".equals(degree.getType()) || "DTS".equals(degree.getType())) {
            return calculateAverage(degree) >= 14;
        } else if ("DUEG".equals(degree.getType())  || "DUEST".equals(degree.getType()) || "DEUP".equals(degree.getType()) ) {
            return calculateAverage(degree) >= 13;
        }  else if ("LP".equals(degree.getType())  || "LF".equals(degree.getType())) {
            return calculateAverage(degree) >= 12;
        }
        return false;
    }

    private float calculateAverage(DegreeDTO degree) {
        if ("Bac+2".equals(degree.getDegreeType())) {
            return (degree.getS1() + degree.getS2() + degree.getS3() + degree.getS4()) / 4;
        } else if ("Bac+3".equals(degree.getDegreeType())) {
            return (degree.getS5() + degree.getS6()) / 2;
        }
        return 0;
    }
}
