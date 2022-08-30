package fa.training.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Class Log4J utility
 * @author FA
 *
 */
public class Log4J {
  private static final Logger logger = Logger.getLogger(Log4J.class);

  /**
   * method configure Log4J.
   * 
   * @return Logger logger
   */
  public static Logger getLogger() {
    PropertyConfigurator.configure(
        Log4J.class.getResourceAsStream("/properties/log4jFILE.properties"));
    return logger;
  }
}
