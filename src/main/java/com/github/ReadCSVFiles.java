package com.github;

import com.github.dto.*;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class ReadCSVFiles {
    public static String fileBefore = "D:/DataFiles/Downloaded/";

    public static void main(String[] args) {
        /* List<CropInsuranceDTO> cropDetails = readCropDetails("csv/crop_insurance.csv"); */
        /*List<StudentDTO> studentInfo = readStudentInfo("csv/StudentInfo.csv");*/
        /* List<EmployeeDTO> employeeInfo = readEmployeeInfo("csv/employee.csv");*/
        //List<CropInsuranceDTO> hrDetails = readHRDetails("csv/50000_HR_Records.csv");
       /* List<Countries> countriesRegions = readCountriesRegions("csv/CountriesRegions.csv");*/
        List<SalesOrderDTO> salesOrderDetails = readSalesOrderDetails("csv/100000_Sales_Order.csv");
        System.out.println("salesOrderDetails===" + salesOrderDetails.size());

    }

    private static List<CropInsuranceDTO> readCropDetails(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CropInsuranceDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    private static List<StudentDTO> readStudentInfo(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<StudentDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(StudentDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    private static List<EmployeeDTO> readEmployeeInfo(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<EmployeeDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(EmployeeDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    private static List<Countries> readCountriesRegions(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Countries> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(Countries.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    private static List<SalesOrderDTO> readSalesOrderDetails(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<SalesOrderDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(SalesOrderDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }

    private static List<CropInsuranceDTO> readHRDetails(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<CropInsuranceDTO> listCrop = null;
        try {
            listCrop = new CsvToBeanBuilder(new FileReader(fileBefore + fileAfter))
                    .withType(CropInsuranceDTO.class)
                    .build()
                    .parse();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listCrop;
    }
}
