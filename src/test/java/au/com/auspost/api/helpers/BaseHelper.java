package au.com.auspost.api.helpers;

import au.com.auspost.Utils.TestProperties;
import au.com.auspost.api.context.ApplicationContext;
import au.com.auspost.api.stepdefinitions.SharedData;
import io.restassured.http.Header;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

public class BaseHelper {

  private final static Logger logger = Logger.getLogger("BaseHelper.class");
  protected SharedData sharedData;
  protected List<Header> headerList;

  public BaseHelper() {
    this.headerList = new LinkedList<>();
    this.sharedData = ApplicationContext.getSharedData();
    headerList.add(new Header("auth-key", TestProperties.get("auth-key")));
  }
}
