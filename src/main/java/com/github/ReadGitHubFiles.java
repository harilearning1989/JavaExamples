package com.github;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ReadGitHubFiles {

    public static void main(String[] args) throws Exception {
        readCropData();
    }

    private static void readCropData() throws Exception {
        String link = "https://raw.githubusercontent.com/harilearning1989/DataFiles/master/csv/crop_insurance.csv";
        URL cropUrl = new URL(link);
        HttpURLConnection cropHttp = (HttpURLConnection) cropUrl.openConnection();
        Map<String, List<String>> cropHeader = cropHttp.getHeaderFields();

        for (String header : cropHeader.get(null)) {
            if (header.contains(" 302 ") || header.contains(" 301 ")) {
                System.out.println("Location");
                link = cropHeader.get("Location").get(0);
                cropUrl = new URL(link);
                cropHttp = (HttpURLConnection) cropUrl.openConnection();
                cropHeader = cropHttp.getHeaderFields();
            }
        }
        InputStream cropStream = cropHttp.getInputStream();
        String cropResponse = cropGetStringFromStream(cropStream);
        System.out.println(cropResponse);
    }

    private static String cropGetStringFromStream(InputStream cropStream) throws IOException {
        if (cropStream != null) {
            Writer cropWriter = new StringWriter();
            char[] cropBuffer = new char[2048];
            try {
                Reader cropReader = new BufferedReader(new InputStreamReader(cropStream, "UTF-8"));
                int counter;
                while ((counter = cropReader.read(cropBuffer)) != -1) {
                    cropWriter.write(cropBuffer, 0, counter);
                }
            } finally {
                cropStream.close();
            }
            return cropWriter.toString();
        } else {
            return "No Contents";
        }
    }
}