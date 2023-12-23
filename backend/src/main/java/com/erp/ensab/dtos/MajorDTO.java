package com.erp.ensab.dtos;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class MajorDTO {
    private String id;
    private String name;
    private List<String> candidateIds;
}
