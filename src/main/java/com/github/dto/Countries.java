package com.github.dto;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "country_id",
        "country_name",
        "alpha2",
        "alpha3",
        "country_code",
        "region",
        "sub_region",
        "intermediate_region",
        "region_code",
        "sub_region_code",
        "intermediate_region_code"
})
public class Countries {

    @JsonProperty("country_id")
    private Integer countryId;
    @JsonProperty("country_name")
    private String countryName;
    @JsonProperty("alpha2")
    private String alpha2;
    @JsonProperty("alpha3")
    private String alpha3;
    @JsonProperty("country_code")
    private Integer countryCode;
    @JsonProperty("region")
    private String region;
    @JsonProperty("sub_region")
    private String subRegion;
    @JsonProperty("intermediate_region")
    private String intermediateRegion;
    @JsonProperty("region_code")
    private Integer regionCode;
    @JsonProperty("sub_region_code")
    private Integer subRegionCode;
    @JsonProperty("intermediate_region_code")
    private Integer intermediateRegionCode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("country_id")
    public Integer getCountryId() {
        return countryId;
    }

    @JsonProperty("country_id")
    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    @JsonProperty("country_name")
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("alpha2")
    public String getAlpha2() {
        return alpha2;
    }

    @JsonProperty("alpha2")
    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    @JsonProperty("alpha3")
    public String getAlpha3() {
        return alpha3;
    }

    @JsonProperty("alpha3")
    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    @JsonProperty("country_code")
    public Integer getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(Integer countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("region")
    public String getRegion() {
        return region;
    }

    @JsonProperty("region")
    public void setRegion(String region) {
        this.region = region;
    }

    @JsonProperty("sub_region")
    public String getSubRegion() {
        return subRegion;
    }

    @JsonProperty("sub_region")
    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    @JsonProperty("intermediate_region")
    public String getIntermediateRegion() {
        return intermediateRegion;
    }

    @JsonProperty("intermediate_region")
    public void setIntermediateRegion(String intermediateRegion) {
        this.intermediateRegion = intermediateRegion;
    }

    @JsonProperty("region_code")
    public Integer getRegionCode() {
        return regionCode;
    }

    @JsonProperty("region_code")
    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    @JsonProperty("sub_region_code")
    public Integer getSubRegionCode() {
        return subRegionCode;
    }

    @JsonProperty("sub_region_code")
    public void setSubRegionCode(Integer subRegionCode) {
        this.subRegionCode = subRegionCode;
    }

    @JsonProperty("intermediate_region_code")
    public Integer getIntermediateRegionCode() {
        return intermediateRegionCode;
    }

    @JsonProperty("intermediate_region_code")
    public void setIntermediateRegionCode(Integer intermediateRegionCode) {
        this.intermediateRegionCode = intermediateRegionCode;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
