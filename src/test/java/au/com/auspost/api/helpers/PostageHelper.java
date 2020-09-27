package au.com.auspost.api.helpers;

import au.com.auspost.Utils.RestInvocationUtil;
import au.com.auspost.Utils.URLResources;
import au.com.auspost.api.model.PostageResultResponse;
import au.com.auspost.api.model.PostcodeSearchResponse;
import au.com.auspost.api.stepdefinitions.ServiceHooks;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class PostageHelper extends BaseHelper {

    RestInvocationUtil invocationUtil;

    public PostageHelper() {
        this.invocationUtil = ServiceHooks.restInvocationUtil;
    }

    public PostcodeSearchResponse getPostCodesForStateAndSuburb(String state, String suburb) throws Throwable {
        String endPoint = URLResources.POSTCODE_SEARCH;
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("q", suburb);
        queryParams.put("state",state);
        Map<String, String> mapWebserviceResponse = new HashMap<String, String>();
        mapWebserviceResponse = invocationUtil.invokeGetWithHeaders(endPoint, queryParams,headerList);
        String responseStr = mapWebserviceResponse.get("response");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PostcodeSearchResponse postcodeSearchResponse = mapper.readValue(responseStr, PostcodeSearchResponse.class);
        return postcodeSearchResponse;
    }

    public PostageResultResponse getPriceForService(String length,String width, String height, String weight, int fromPostCode, int toPostCode, String serviceCode) throws Throwable {
        String endPoint = URLResources.CALCULATE_POSTAGE;
        Map<String, String> queryParams = new HashMap<String, String>();
        queryParams.put("length", length);
        queryParams.put("width",width);
        queryParams.put("height",height);
        queryParams.put("weight",weight);
        queryParams.put("from_postcode",String.valueOf(fromPostCode));
        queryParams.put("to_postcode",String.valueOf(toPostCode));
        queryParams.put("service_code",serviceCode);
        Map<String, String> mapWebserviceResponse = new HashMap<String, String>();
        mapWebserviceResponse = invocationUtil.invokeGetWithHeaders(endPoint, queryParams,headerList);
        String responseStr = mapWebserviceResponse.get("response");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        PostageResultResponse postageResultResponse = mapper.readValue(responseStr, PostageResultResponse.class);
        return postageResultResponse;
    }

}
