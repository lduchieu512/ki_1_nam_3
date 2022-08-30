package fa.training.utils;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Class Log4J utility
 * @author FA
 *
 */
public class LogFactory {
  private static final Logger logger = Logger.getLogger(LogFactory.class);

  /**
   * method configure Log4J.
   * 
   * @return Logger logger
   */
  public static Logger getLogger() {
    PropertyConfigurator.configure(
        LogFactory.class.getResourceAsStream("/properties/log4jFILE.properties"));
    return logger;
  }
}
