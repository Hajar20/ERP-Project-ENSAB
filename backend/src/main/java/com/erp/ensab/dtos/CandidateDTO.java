package com.erp.ensab.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CandidateDTO {

    private String id;
    private String cne;
    private String firstname;
    private String lastname;
    private String birthdate;
    private String cni;
    private MajorDTO major;
    private long phone;
    private char sexe;
    private List<DegreeDTO> degrees;
    private BacDTO bac;

}
