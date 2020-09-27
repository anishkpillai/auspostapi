package au.com.auspost.Utils;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.*;

import static io.restassured.RestAssured.given;

public class RestInvocationUtil {

  private Map<String, String> mapWebServiceResponse = new HashMap<>();
  public Response response;
  public ArrayList<String> endPoints = new ArrayList<>();
  public ArrayList<String> requests = new ArrayList<>();
  public ArrayList<Response> responses = new ArrayList<>();



  public Map<String, String> invokeGetWithHeaders(String endPoint, Map<String, ?> queryParams, List<Header> headerList) {
    response = getRestWithDynamicHeaders(endPoint, queryParams, headerList);
    String strResponse = response.getBody().asString();
    mapWebServiceResponse.put("response", strResponse);
    mapWebServiceResponse.put("statusCode", Integer.toString(response.getStatusCode()));
    mapWebServiceResponse.put("contentType", (response.contentType()));
    endPoints.add(endPoint);
    requests.add(queryParams.toString());
    responses.add(response);
    return mapWebServiceResponse;
  }


  private Response getRestWithDynamicHeaders(String endPoint, Map<String, ?> params, List<Header> dynamicHeaderList) {
    try {
      RestAssured.baseURI = TestProperties.get("BASE_URI");
      Headers headers = new Headers(dynamicHeaderList);
      response = given()
          // .proxy(TestProperties.get("LOCAL_PROXY"))
          .header("Content-Type", "application/json")
          .header("Accept", "application/json")
          .headers(headers)
          .params(params)
          .when()
          .get(endPoint)
          .then()
          .extract().response();
    } catch (Exception e) {
      e.printStackTrace();
      StringWriter errors = new StringWriter();
      e.printStackTrace(new PrintWriter(errors));
      Assert.assertTrue(false, "Endpoint::" + endPoint + "Error::" + e.getMessage() + "Stack Trace::" + errors.toString());
    }
    return response;

  }

}
