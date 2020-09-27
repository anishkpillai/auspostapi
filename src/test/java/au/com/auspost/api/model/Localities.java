package au.com.auspost.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)

public class Localities {

    @JsonProperty("locality")
    private Locality locality = null;

    @JsonProperty("locality")
    public Locality getLocality() {
        return locality;
    }

    @JsonProperty("locality")
    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    @Override
    public String toString() {
        return "Localities{" +
                "locality=" + locality +
                '}';
    }
}
