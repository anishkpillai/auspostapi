package au.com.auspost.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "service",
        "delivery_time",
        "total_cost",
        "costs"
})

public class PostageResult {
    private String service;
    @JsonProperty("delivery_time")
    private String deliveryTime;
    @JsonProperty("total_cost")
    private String totalCost;
    @JsonProperty("costs")
    private Object costs;

    @JsonProperty("service")
    public String getService() {
        return service;
    }

    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
    }

    @JsonProperty("delivery_time")
    public String getDeliveryTime() {
        return deliveryTime;
    }

    @JsonProperty("delivery_time")
    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @JsonProperty("total_cost")
    public String getTotalCost() {
        return totalCost;
    }

    @JsonProperty("total_cost")
    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    @JsonProperty("costs")
    public Object getCosts() {
        return costs;
    }

    @JsonProperty("costs")
    public void setCosts(Object costs) {
        this.costs = costs;
    }

}
