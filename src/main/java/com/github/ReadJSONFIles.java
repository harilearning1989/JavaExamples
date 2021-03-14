package com.github;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dto.Countries;
import com.google.common.base.Charsets;
import com.utils.CommonUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReadJSONFIles {

    public static String fileBefore = "D:/DataFiles/Downloaded/";

    public static void main(String[] args) {
        //readCountries("json/Countries.json");
        //readJsonStaticData();
        /*ClassLoader loader = ReadJSONFIles.class.getClassLoader();
        System.out.println(loader.getResource("com/github/ReadJSONFIles.class"));*/
        testHson();
    }

    public static void testHson(){
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(
                    new FileReader("D:/DataFiles/Downloaded/json/Countries.json"));//path to the JSON file.
            String json = data.toJSONString();
            System.out.println(json);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public static List<Countries> readCountries(String fileAfter) {
        try {
            DownloadGitHubFiles.downloadFile(fileAfter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Countries> countryRegion = null;
        try {
            String fixture = CommonUtils.readResource(fileBefore + fileAfter, Charsets.UTF_8);
            ObjectMapper objectMapper = new ObjectMapper();
            countryRegion = objectMapper.readValue(fixture, objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Countries.class));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countryRegion;
    }

    private static void readJsonStaticData() {
        String jsonString = "{\"id\":\"102\", \"name\":\"Raja Ramesh\", \"address\":[{\"area\":\"Madhapur\", \"city\":\"Hyderabad\"}]}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        User user = null;
        try {
            jsonNode = objectMapper.readTree(jsonString);
            user = objectMapper.treeToValue(jsonNode, User.class);
            System.out.println("=========================");
            System.out.println(user.getName());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}

class User {
    private int id;
    private String name;
    private Address[] address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address[] getAddress() {
        return address;
    }

    public void setAddress(Address[] address) {
        this.address = address;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(id).append(",");
        sb.append(name).append(",");
        for (Address address1 : address) {
            sb.append(address1).append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}

// Address class
class Address {
    private String area;
    private String city;

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(area).append(",");
        sb.append(city);
        sb.append("}");
        return sb.toString();
    }
}