package com.github;

import com.utils.CommonUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ReadCountries {

    public static void main(String[] args) throws Exception {
        downloadFile("json/Countries.json");
    }

    public static void downloadFile(String fileName) throws Exception {
        String sUrl = "https://raw.githubusercontent.com/harilearning1989/DataFiles/master/" + fileName;
        URL url = new URL(sUrl);
        File file = null;
        if (CommonUtils.isWindows()) {
            file = new File("D:/DataFiles/Downloaded/" + fileName);
        } else if (CommonUtils.isLinux()) {
            file = new File("D:/DataFiles/Downloaded/" + fileName);
        }
        ReadCountries.copyURLToFile(url, file);
    }

    public static void copyURLToFile(URL url, File file) {
        try {
            InputStream input = url.openStream();
            if (file.exists()) {
                if (file.isDirectory())
                    throw new IOException("File '" + file + "' is a directory");
                if (!file.canWrite())
                    throw new IOException("File '" + file + "' cannot be written");
            } else {
                File parent = file.getParentFile();
                if ((parent != null) && (!parent.exists()) && (!parent.mkdirs())) {
                    throw new IOException("File '" + file + "' could not be created");
                }
            }

            if (!file.exists()) {
                FileOutputStream output = new FileOutputStream(file);

                byte[] buffer = new byte[4096];
                int n = 0;
                while (-1 != (n = input.read(buffer))) {
                    output.write(buffer, 0, n);
                }
                input.close();
                output.close();
                System.out.println("File '" + file + "' downloaded successfully!");
            } else {
                System.out.println("File '" + file + "' already downloaded!");
            }
        } catch (IOException ioEx) {
            ioEx.printStackTrace();
        }
    }
}