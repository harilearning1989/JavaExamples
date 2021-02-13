package com.oracle.model;

import java.util.Objects;

public class Countries {

    private int id;
    private String name;
    private char alpha2;
    private char alpha3;
    private int code;
    private String region;
    private String subRegion;
    private String intRegion;
    private int regionCode;
    private int subRegionCode;
    private int intRegionCode;

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

    public char getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(char alpha2) {
        this.alpha2 = alpha2;
    }

    public char getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(char alpha3) {
        this.alpha3 = alpha3;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getIntRegion() {
        return intRegion;
    }

    public void setIntRegion(String intRegion) {
        this.intRegion = intRegion;
    }

    public int getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(int regionCode) {
        this.regionCode = regionCode;
    }

    public int getSubRegionCode() {
        return subRegionCode;
    }

    public void setSubRegionCode(int subRegionCode) {
        this.subRegionCode = subRegionCode;
    }

    public int getIntRegionCode() {
        return intRegionCode;
    }

    public void setIntRegionCode(int intRegionCode) {
        this.intRegionCode = intRegionCode;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", alpha2=" + alpha2 +
                ", alpha3=" + alpha3 +
                ", code=" + code +
                ", region='" + region + '\'' +
                ", subRegion='" + subRegion + '\'' +
                ", intRegion='" + intRegion + '\'' +
                ", regionCode=" + regionCode +
                ", subRegionCode=" + subRegionCode +
                ", intRegionCode=" + intRegionCode +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Countries countries = (Countries) o;
        return id == countries.id &&
                alpha2 == countries.alpha2 &&
                alpha3 == countries.alpha3 &&
                code == countries.code &&
                regionCode == countries.regionCode &&
                subRegionCode == countries.subRegionCode &&
                intRegionCode == countries.intRegionCode &&
                Objects.equals(name, countries.name) &&
                Objects.equals(region, countries.region) &&
                Objects.equals(subRegion, countries.subRegion) &&
                Objects.equals(intRegion, countries.intRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, alpha2, alpha3, code, region, subRegion, intRegion, regionCode, subRegionCode, intRegionCode);
    }
}