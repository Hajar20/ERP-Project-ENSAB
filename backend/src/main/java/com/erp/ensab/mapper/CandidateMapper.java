package com.erp.ensab.mapper;

import com.erp.ensab.dtos.CandidateDTO;
import com.erp.ensab.entities.Candidate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CandidateMapper {


    public static CandidateDTO  mapToCandidateDto(Candidate candidate) {
        if (candidate == null) {
            return null;
        }

        return CandidateDTO.builder()
                .id(candidate.getID())
                .cne(candidate.getCne())
                .firstname(candidate.getFirstname())
                .lastname(candidate.getLastname())
                .birthdate(formatDate(candidate.getBirthdate()))
                .cni(candidate.getCni())
                .major(MajorMapper.mapToMajorDTO(candidate.getMajor()))
                .phone(candidate.getPhone())
                .sexe(candidate.getSexe())
                .degrees(DegreeMapper.mapToDegreeDTOs(candidate.getDegrees()))
                .bac(BacMapper.mapToBacDTO(candidate.getBac()))
                .build();
    }


    public static Candidate mapToCandidate(CandidateDTO candidateDTO) {
        if (candidateDTO == null) {
            return null;
        }
        return Candidate.builder()
                .cne(candidateDTO.getCne())
                .firstname(candidateDTO.getFirstname())
                .lastname(candidateDTO.getLastname())
                .birthdate(parseDate(candidateDTO.getBirthdate()))
                .cni(candidateDTO.getCni())
                .major(MajorMapper.mapToMajor(candidateDTO.getMajor()))
                .phone(candidateDTO.getPhone())
                .sexe(candidateDTO.getSexe())
                .degrees(DegreeMapper.mapToDegrees(candidateDTO.getDegrees()))
                .bac(BacMapper.mapToBac(candidateDTO.getBac()))
                .build();
    }



    private static Date parseDate(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }
    private static String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
