package com.erp.ensab.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

@RestController
@RequestMapping("/api")
public class ExcelToPdf {
    private static final Logger logger = LoggerFactory.getLogger(ExcelToPdf.class);

    @PostMapping("/processExcel")
public ResponseEntity<List<Map<String, String>>> processExcel(@RequestParam("file") MultipartFile file, @RequestParam("value") int threshold) {
    try {
        // Lire le fichier Excel
        Workbook workbook = new XSSFWorkbook(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);

        List<Map<String, String>> filteredRows = new ArrayList<>();

        // Parcourir les lignes du fichier Excel et filtrer selon la condition
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            if (row.getRowNum() == 0) continue; // Ignorer l'en-tête

            int score = (int) row.getCell(3).getNumericCellValue(); // Assurez-vous que l'indice 3 correspond à la colonne 'Score'

            // Filtrer les lignes selon la condition
            if (score > threshold) {
                Map<String, String> rowData = new HashMap<>();

                // Copier les données de la ligne filtrée vers la liste
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    Cell cell = row.getCell(i);
                    String cellValue = getCellValueAsString(cell);
                    rowData.put(sheet.getRow(0).getCell(i).getStringCellValue(), cellValue);
                }

                filteredRows.add(rowData);
            }
        }

        // Fermer le classeur
        workbook.close();

        return ResponseEntity.ok(filteredRows);
    } catch (IOException e) {
        e.printStackTrace();
        // Gérer l'exception appropriée
        return ResponseEntity.badRequest().build();
    }
}


    // Méthode utilitaire pour obtenir la valeur de la cellule sous forme de chaîne
    private String getCellValueAsString(Cell cell) {
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            default:
                return "";
        }
    }
}
