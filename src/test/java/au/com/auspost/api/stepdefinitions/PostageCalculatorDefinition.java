package au.com.auspost.api.stepdefinitions;

import au.com.auspost.api.context.ApplicationContext;
import au.com.auspost.api.helpers.PostageHelper;
import au.com.auspost.api.model.PostageResultResponse;
import au.com.auspost.api.model.PostcodeSearchResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class PostageCalculatorDefinition extends PostageHelper {

    private SharedData sharedData;

    public PostageCalculatorDefinition() {
        this.sharedData = ApplicationContext.getSharedData();
    }

    @Given("^I store one postcode from state \"([^\"]*)\" with suburb name \"([^\"]*)\"$")
    public void i_store_one_postcode_from_state_with_suburb_name(String state, String suburb) throws Throwable {
        PostcodeSearchResponse postcodeSearchResponse = getPostCodesForStateAndSuburb(state,suburb);
        sharedData.fromPostCode = postcodeSearchResponse.getLocalities().getLocality().getPostcode();
    }

    @Given("^I store another postcode from state \"([^\"]*)\" with suburb name \"([^\"]*)\"$")
    public void i_store_another_postcode_from_state_with_suburb_name(String state, String suburb) throws Throwable {
        PostcodeSearchResponse postcodeSearchResponse = getPostCodesForStateAndSuburb(state,suburb);
        sharedData.toPostCode = postcodeSearchResponse.getLocalities().getLocality().getPostcode();
    }

    @When("^I search and store price for dimension \"([^\"]*)\" with weight \"([^\"]*)\" for service type \"([^\"]*)\"$")
    public void i_search_and_store_price_for_dimension_for_service_type(String dimension, String weight, String serviceCode) throws Throwable {

        String[] result = dimension.split(":");
        PostageResultResponse postageResultResponse = getPriceForService(result[0],result[1],result[2],weight, sharedData.fromPostCode,sharedData.toPostCode,serviceCode);
        sharedData.postageCost = postageResultResponse.getPostageResult().getTotalCost();
    }

    @Then("^I verify the total cost to be \"([^\"]*)\"$")
    public void i_verify_the_total_cost_to_be(String totalCost) throws Throwable {
        Assert.assertTrue(totalCost.equalsIgnoreCase(sharedData.postageCost), "The Cost is not matching");
    }
}
