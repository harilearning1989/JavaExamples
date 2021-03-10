package com.oracle;

import com.oracle.model.Countries;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountriesDemo {
    public static void main(String[] args) {
        getCountriesDetails();
    }

    private static final String QUERY = "select * from COUNTRIES ";

    public static List<Countries> getCountriesDetails() {

        List<Countries> countriesList = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(QUERY)) {

            while (rs.next()) {
                Countries countries = new Countries();
                int id = rs.getInt("COUNTRY_ID");
                String name = rs.getString("COUNTRY_NAME");
                int code = Integer.parseInt(rs.getString("COUNTRY_CODE"));
                String region = rs.getString("REGION");
                String subRegion = rs.getString("SUB_REGION");
                String intRegion = rs.getString("INTERMEDIATE_REGION");
                int regionCode = 0;
                if (rs.getString("REGION_CODE") != null) {
                    regionCode = Integer.parseInt(rs.getString("REGION_CODE"));
                }
                int subRegionCode = 0;
                if (rs.getString("SUB_REGION_CODE") != null) {
                    subRegionCode = Integer.parseInt(rs.getString("SUB_REGION_CODE"));
                }

                int intRegionCode = 0;
                if (rs.getString("INTERMEDIATE_REGION_CODE") != null) {
                    intRegionCode = Integer.parseInt(rs.getString("INTERMEDIATE_REGION_CODE"));
                }

                countries.setId(id);
                countries.setName(name);
                countries.setCode(code);
                countries.setRegion(region);
                countries.setSubRegion(subRegion);
                countries.setIntRegion(intRegion);
                countries.setRegionCode(regionCode);
                countries.setSubRegionCode(subRegionCode);
                countries.setIntRegionCode(intRegionCode);

                countriesList.add(countries);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countriesList;
    }

}
