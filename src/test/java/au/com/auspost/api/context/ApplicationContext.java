package au.com.auspost.api.context;

import au.com.auspost.api.stepdefinitions.SharedData;

public class ApplicationContext {

  private ApplicationContext() {
  }

  private enum Singleton {

    INSTANCE;

    private SharedData sharedData;

    Singleton() {
      sharedData = new SharedData();
    }

    public SharedData getSharedData() {
      return sharedData;
    }
  }

  public static SharedData getSharedData() {
    return Singleton.INSTANCE.getSharedData();
  }
}
