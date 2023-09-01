package com.bing.utils;

import com.bing.entity.UserInfo;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {
    public static ByteArrayInputStream generateExcel(List<UserInfo> studentList) throws IOException {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Student Data");

            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("NickName");
            headerRow.createCell(1).setCellValue("IdNum");
            headerRow.createCell(2).setCellValue("UserName");

            // Create data rows
            int rowNum = 1;
            for (UserInfo student : studentList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(student.getNickName());
                row.createCell(1).setCellValue(student.getIdNumber());
                row.createCell(2).setCellValue(student.getUserName());
            }

            // Write the Excel data to a ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            // Convert ByteArrayOutputStream to ByteArrayInputStream

            return new ByteArrayInputStream(outputStream.toByteArray());
        }
    }
}

