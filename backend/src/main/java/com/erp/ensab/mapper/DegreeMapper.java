package com.erp.ensab.mapper;

import com.erp.ensab.dtos.DegreeDTO;

import com.erp.ensab.entities.Degree;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DegreeMapper {
    public static DegreeDTO mapToDegreeDTO(Degree degree) {
        if (degree == null) {
            return null;
        }
        return DegreeDTO.builder()
                .type(degree.getType())
                .degreeType(degree.getDegreeType())
                .speciality(degree.getSpeciality())
                .diplomaDate(formatDate(degree.getDiplomaDate()))
                .s1(degree.getS1())
                .s2(degree.getS2())
                .s3(degree.getS3())
                .s4(degree.getS4())
                .s5(degree.getS5())
                .s6(degree.getS6())
                .college(degree.getCollege())
                .build();
    }

    public static Degree mapToDegree(DegreeDTO degreeDTO) {
        if (degreeDTO == null) {
            return null;
        }
        return Degree.builder()
                .type(degreeDTO.getType())
                .degreeType(degreeDTO.getDegreeType())
                .speciality(degreeDTO.getSpeciality())
                .diplomaDate(parseDate(degreeDTO.getDiplomaDate()))
                .s1(degreeDTO.getS1())
                .s2(degreeDTO.getS2())
                .s3(degreeDTO.getS3())
                .s4(degreeDTO.getS4())
                .s5(degreeDTO.getS5())
                .s6(degreeDTO.getS6())
                .college(degreeDTO.getCollege())
                .build();
    }

    public static List<Degree> mapToDegrees(List<DegreeDTO> degreeDTOs) {
        return degreeDTOs.stream()
                .map(dto -> mapToDegree(dto))
                .collect(Collectors.toList());
    }
    public static List<DegreeDTO> mapToDegreeDTOs(List<Degree> degrees) {
        return degrees.stream()
                .map(DegreeMapper::mapToDegreeDTO)
                .collect(Collectors.toList());
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
