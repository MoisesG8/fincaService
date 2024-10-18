package com.coffe.coffeService.utilerias;
import com.coffe.coffeService.dto.SeguimientoPlanificacionDTO;
import com.coffe.coffeService.models.Planificacion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExcelCoffe {

    public byte[] generarExcel(List<SeguimientoPlanificacionDTO> seguimientos, String nombrePlanificacion, String nombreFinca, String nombreProductor) throws IOException {

        Workbook workbook =  new XSSFWorkbook();

        Sheet sheet = workbook.createSheet();

        //Encabezados
        String [] encabezados = {"ACTIVIDAD REALIZADA", "FECHA DE REALIZACION", "OBSERVACIONES"};
        List<String> encabezadoColumnas = new ArrayList<>();
        List<String> informacionCabecera = new ArrayList<>();
        informacionCabecera.add("****REPORTE DE SEGUIMIENTOS****");

        /**
         * SE AGREGAN LOS ENCABEZADOS DE LAS COLUMNAS
         * **/
        for (int i = 0; i < encabezados.length; i++) {
            encabezadoColumnas.add(encabezados[i]);
        }

        /**
         * Escribir datos en el libro de trabajo
         * **/
        int fila = 0;
        int colNum = 0;
        for (int i = 0; i < informacionCabecera.size(); i++) {
            Row infoRow = sheet.createRow(fila);
            Cell cell = infoRow.createCell(0);
            cell.setCellValue(informacionCabecera.get(i));
            fila++;
        }

        Row headerRow = sheet.createRow(fila + 1);
        for (int i = 0; i < encabezadoColumnas.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(encabezadoColumnas.get(i));

        }
        fila++;

        for(SeguimientoPlanificacionDTO seguimiento : seguimientos) {
            Cell cell;
            Row dataRow = sheet.createRow(fila + 1);

            colNum = 0;
            cell = dataRow.createCell(colNum);
            cell.setCellValue(seguimiento.getActividadRealizada());
            colNum++;

            cell = dataRow.createCell(colNum);
            cell.setCellValue(seguimiento.getFecha().toString());
            colNum++;

            cell = dataRow.createCell(colNum);
            cell.setCellValue(seguimiento.getObservaciones());
            fila++;
        }

        // Convertir el libro de trabajo a un arreglo de bytes
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        byte[] excelBytes = outputStream.toByteArray();

        return excelBytes;
    }
}
