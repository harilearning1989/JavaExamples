package com.github;

public class ReadGitHubCSVFiles {

    public static void downloadCropInsuranceFile() {
        try {
            DownloadGitHubFiles.downloadFile("csv/crop_insurance.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadHRDetails() {
        try {
            DownloadGitHubFiles.downloadFile("csv/50000_HR_Records.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadSalesOrderDetails() {
        try {
            DownloadGitHubFiles.downloadFile("csv/100000_Sales_Order.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadCountriesRegions() {
        try {
            DownloadGitHubFiles.downloadFile("csv/CountriesRegions.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadStudentInfo() {
        try {
            DownloadGitHubFiles.downloadFile("csv/StudentInfo.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void downloadEmployeeInfo() {
        try {
            DownloadGitHubFiles.downloadFile("csv/employee.csv");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
