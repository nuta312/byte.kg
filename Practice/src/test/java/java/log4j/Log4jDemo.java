package java.log4j;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4jDemo {
  final static Logger logger = LogManager.getLogger(Log4jDemo.class);

    public static void main(String[] args) {

        ConsoleAppender consoleAppender = new ConsoleAppender();
        consoleAppender.setThreshold(Level.ALL);
        System.out.println("Hello World....!   \n");
        logger.info("This is information message");
        logger.error("This is an error message");
        logger.warn("This is an warning message");
        logger.fatal("This is an fatal message");

        System.out.println(" \n Completed");



    }
}
