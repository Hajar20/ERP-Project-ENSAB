package com.erp.ensab.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class DegreeDTO {

    private String id;
    private String candidateId;
    private String type;
    private String degreeType;
    private String speciality;
    private String diplomaDate;
    private float s1;
    private float s2;
    private float s3;
    private float s4;
    private float s5;
    private float s6;
    private String college;
}
