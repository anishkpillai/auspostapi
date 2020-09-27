package au.com.auspost.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class Locality {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonPropertyOrder({
            "category",
            "id",
            "latitude",
            "location",
            "longitude",
            "postcode",
            "state"
    })

    @JsonProperty("category")
    private String category;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("latitude")
    private Double latitude;
    @JsonProperty("location")
    private String location;
    @JsonProperty("longitude")
    private Double longitude;
    @JsonProperty("postcode")
    private Integer postcode;
    @JsonProperty("state")
    private String state;

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("latitude")
    public Double getLatitude() {
        return latitude;
    }

    @JsonProperty("latitude")
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("location")
    public String getLocation() {
        return location;
    }

    @JsonProperty("location")
    public void setLocation(String location) {
        this.location = location;
    }

    @JsonProperty("longitude")
    public Double getLongitude() {
        return longitude;
    }

    @JsonProperty("longitude")
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("postcode")
    public Integer getPostcode() {
        return postcode;
    }

    @JsonProperty("postcode")
    public void setPostcode(Integer postcode) {
        this.postcode = postcode;
    }

    @JsonProperty("state")
    public String getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Locality{" +
                "category='" + category + '\'' +
                ", id=" + id +
                ", latitude=" + latitude +
                ", location='" + location + '\'' +
                ", longitude=" + longitude +
                ", postcode=" + postcode +
                ", state='" + state + '\'' +
                '}';
    }
}

