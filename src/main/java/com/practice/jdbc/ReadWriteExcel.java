package com.practice.jdbc;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReadWriteExcel {

    //https://howtodoinjava.com/library/readingwriting-excel-files-in-java-poi-tutorial/

    public static void writeExcel() {
        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Employee Data");

        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"ID", "NAME", "LASTNAME"});
        data.put("2", new Object[]{1, "Amit", "Shukla"});
        data.put("3", new Object[]{2, "Lokesh", "Gupta"});
        data.put("4", new Object[]{3, "John", "Adwards"});
        data.put("5", new Object[]{4, "Brian", "Schultz"});

        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row row = sheet.createRow(rownum++);
            Object[] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr) {
                Cell cell = row.createCell(cellnum++);
                if (obj instanceof String)
                    cell.setCellValue((String) obj);
                else if (obj instanceof Integer)
                    cell.setCellValue((Integer) obj);
            }
        }
        try {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("howtodoinjava_demo.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("howtodoinjava_demo.xlsx written successfully on disk.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<ReadExcelModel> readExcel() {
        List<ReadExcelModel> list = new ArrayList<ReadExcelModel>();
        try {
            //FileInputStream file = new FileInputStream(new File("howtodoinjava_demo.xlsx"));
            //Create Workbook instance holding reference to .xlsx file
            //XSSFWorkbook workbook = new XSSFWorkbook("howtodoinjava_demo.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook("SuperMarket.xlsx");
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            int i=0;

            ReadExcelModel read = null;
            while (rowIterator.hasNext()) {
                read = new ReadExcelModel();
                Row row = rowIterator.next();
                if(row.getRowNum()>0) {

                    read.setOrderID(row.getCell(1).toString());
                    read.setOrderDate(row.getCell(2).getDateCellValue());
                    read.setShipDate(row.getCell(3).getDateCellValue());
                    read.setShipMode(row.getCell(4).toString());
                    read.setCustomerID(row.getCell(5).toString());
                    read.setCustomerName(row.getCell(6).toString());
                    read.setSegment(row.getCell(7).toString());
                    read.setCountry(row.getCell(8).toString());
                    read.setCity(row.getCell(9).toString());
                    read.setState(row.getCell(10).toString());

                    double postal = Double.parseDouble(row.getCell(11).toString());
                    int postalInt = (int)postal;
                    read.setPostalCode(postalInt);

                    read.setRegion(row.getCell(12).toString());
                    read.setProductID(row.getCell(13).toString());

                    read.setCategory(row.getCell(14).toString());
                    read.setSubCategory(row.getCell(15).toString());
                    read.setProductName(row.getCell(16).toString());

                    postal = Double.parseDouble(row.getCell(17).toString());
                    float sales = (float)postal;
                    read.setSales(sales);
                    postal = Double.parseDouble(row.getCell(18).toString());
                    int quantityInt = (int)postal;
                    read.setQuantity(quantityInt);
                    postal = Double.parseDouble(row.getCell(19).toString());
                    float discount = (float)postal;
                    read.setDiscount(discount);
                    postal = Double.parseDouble(row.getCell(20).toString());
                    float profit = (float)postal;
                    read.setProfit(profit);

                    System.out.println(read.getOrderID()+"=="+read.getOrderDate()+"==="+read.getShipDate()+"===="+read.getQuantity());

                }
                list.add(read);
                //For each row, iterate through all the columns
                /* Iterator<Cell> cellIterator = row.cellIterator();

               if(row.getRowNum()>0) {

                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        //Check the cell type and format accordingly
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_NUMERIC:
                                //System.out.print(cell.getNumericCellValue() );
                                break;
                            case Cell.CELL_TYPE_STRING:
                                //System.out.print(cell.getStringCellValue() );
                                break;
                        }
                    }
                }*/
                //System.out.println("");
               /* i++;
                if(i>10){
                    break;
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<ReadExcelModel> uniqueQuntity = list.stream().filter(distinctByKey(b -> b.getQuantity())).collect(Collectors.toList());
        uniqueQuntity.forEach(x -> System.out.println(x.getQuantity()));
        return list;
    }
    public static void saveStoreData(List<ReadExcelModel> listStore) {

    }
    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


    public static void main(String[] args) {
        //writeExcel();
        List<ReadExcelModel> listStore = readExcel();
        saveStoreData(listStore);
    }
}