package desutine.specorium.utility;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class Log {
    private final Logger logger;

    public Log(Logger modLog) {
        this.logger = modLog;
    }

    /**
     * A severe error that will prevent the application from continuing.
     */
    public void fatal(Object message) {
        log(Level.FATAL, message);
    }

    private void log(Level level, Object message) {
        logger.log(level, message.toString());
    }

    /**
     * A severe error that will prevent the application from continuing.
     */
    public void fatal(Object message, Throwable ex) {
        log(Level.FATAL, message, ex);
    }

    private void log(Level level, Object message, Throwable ex) {
        logger.log(level, message.toString(), ex);
    }

    /**
     * An error in the application, possibly recoverable.
     */
    public void error(Object message, Throwable ex) {
        log(Level.ERROR, message, ex);
    }

    /**
     * An error in the application, possibly recoverable.
     */
    public void error(Object message) {
        log(Level.ERROR, message);
    }

    /**
     * An event that might possible lead to an error.
     */
    public void warning(Object message) {
        log(Level.WARN, message);
    }

    /**
     * An event for informational purposes.
     */
    public void info(Object message) {
        log(Level.INFO, message);
    }

    /**
     * A general debugging event.
     */
    public void debug(Object message) {
        log(Level.DEBUG, message);
    }

    /**
     * A fine-grained debug message, typically capturing the flow through the application.
     */
    public void trace(Object message) {
        log(Level.TRACE, message);
    }
}
