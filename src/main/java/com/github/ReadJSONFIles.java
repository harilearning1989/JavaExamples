package com.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dto.Countries;
import com.utils.CommonUtils;

import java.nio.charset.StandardCharsets;

public class ReadJSONFIles {

    public static Countries readCountries() {
        String fileLocation = "json/Countries.json";
        try {
            DownloadGitHubFiles.downloadFile(fileLocation);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String countriesFileLocation = "D:/DataFiles/Downloaded/" + fileLocation;
        Countries user = null;
        try {
            String fixture = CommonUtils.readResource(countriesFileLocation, StandardCharsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            user = objectMapper.readValue(fixture, Countries.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
}
