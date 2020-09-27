package au.com.auspost.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostageResultResponse {
    @JsonProperty("postage_result")
    private PostageResult postageResult;

    @JsonProperty("postage_result")
    public PostageResult getPostageResult() {
        return postageResult;
    }

    @JsonProperty("postage_result")
    public void setPostageResult(PostageResult postageResult) {
        this.postageResult = postageResult;
    }

    @Override
    public String toString() {
        return "PostageResult{" +
                "postageResult=" + postageResult +
                '}';
    }
}
