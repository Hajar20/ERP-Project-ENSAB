package com.erp.ensab.mapper;

import com.erp.ensab.dtos.MajorDTO;
import com.erp.ensab.entities.Candidate;
import com.erp.ensab.entities.Major;

import java.util.List;
import java.util.stream.Collectors;

public class MajorMapper {

    public static MajorDTO mapToMajorDTO(Major major) {
        if (major == null) {
            return null;
        }
        return MajorDTO.builder()
                .id(major.getID())
                .name(major.getName())
                .build();
    }
    public static Major mapToMajor(MajorDTO majorDTO) {
        if (majorDTO == null) {
            return null;
        }
        return Major.builder()
                .name(majorDTO.getName())
                .build();
    }


    public static List<MajorDTO> mapToMajorDTOs(List<Major> majors) {
        return majors.stream()
                .map(MajorMapper::mapToMajorDTO)
                .collect(Collectors.toList());
    }

}
