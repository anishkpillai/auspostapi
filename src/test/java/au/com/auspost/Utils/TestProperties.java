package au.com.auspost.Utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class TestProperties {

  private static final Properties props;

  static {
    props = new Properties();
    InputStream input = null;
    try {
      if (System.getProperty("env") == null) {
        System.setProperty("env", "uat");
      }
      input = TestProperties.class.getResourceAsStream("/config/test.properties");
      props.load(input);
    } catch (IOException ex) {
      ex.printStackTrace();
    } finally {
      if (input != null) {
        try {
          input.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  public static String get(String propertyName) {
    return props.getProperty(propertyName);
  }

}
