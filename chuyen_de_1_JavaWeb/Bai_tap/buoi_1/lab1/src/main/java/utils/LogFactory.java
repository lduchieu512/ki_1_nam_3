package utils;

import java.util.logging.Logger;

/**
 * Class Log4J utility
 * @author FA
 *
 */
public class LogFactory {
    private static final Logger logger = Logger.getLogger(String.valueOf(LogFactory.class));

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
