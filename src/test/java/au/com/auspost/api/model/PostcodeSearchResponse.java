package au.com.auspost.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PostcodeSearchResponse {
    @JsonInclude(JsonInclude.Include.NON_NULL)

    @JsonProperty("localities")
    private Localities localities;


    @JsonProperty("localities")
    public Localities getLocalities() {
        return localities;
    }

    @JsonProperty("localities")
    public void setLocalities(Localities localities) {
        this.localities = localities;
    }

    @Override
    public String toString() {
        return "PostcodeSearchResponse{" +
                "localities=" + localities +
                '}';
    }
}
