package com.erp.ensab.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BacDTO {
    private String id;
    private String candidateId;
    private String type;
    private String option;
    private String dateObtaining;
    private String distinction;
}
