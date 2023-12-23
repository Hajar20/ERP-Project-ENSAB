package com.erp.ensab.mapper;

import com.erp.ensab.dtos.BacDTO;
import com.erp.ensab.entities.Bac;
import com.erp.ensab.entities.Candidate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BacMapper {
    public static BacDTO mapToBacDTO(Bac bac) {
        if (bac == null) {
            return null;
        }

        return BacDTO.builder()
                .id(bac.getID())
                .type(bac.getType())
                .option(bac.getOption())
                .dateObtaining(formatDate(bac.getDateObtaining()))
                .distinction(bac.getDistinction())
                .build();
    }

    public static List<BacDTO> mapToBacDTOs(List<Bac> bacs) {
        return bacs.stream()
                .map(BacMapper::mapToBacDTO)
                .collect(Collectors.toList());
    }

    public static Bac mapToBac(BacDTO bacDTO) {
        if (bacDTO == null) {
            return null;
        }

        return Bac.builder()
                .type(bacDTO.getType())
                .option(bacDTO.getOption())
                .dateObtaining(parseDate(bacDTO.getDateObtaining()))
                .distinction(bacDTO.getDistinction())
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
