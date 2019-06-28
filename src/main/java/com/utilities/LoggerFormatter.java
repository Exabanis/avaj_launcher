package com.utilities;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerFormatter extends Formatter {
    static Logger logger = Logger.getLogger(LoggerFormatter.class.getName());
    FileHandler fileHandler;

    /**
     *
     * This create file handler, formatter, assign formatter to the logger and logs the message
     * to the simulation log
     * This throws an Exception if it is unsble to log to the simulation log
     * @param msg
     *
     */
    public void log(String msg){
        try{
            fileHandler = new FileHandler("simulation.txt", true);
            logger.addHandler(fileHandler);
            LoggerFormatter formatter = new LoggerFormatter();
            fileHandler.setFormatter(formatter);
            logger.setUseParentHandlers(false);
            logger.info(msg);
            fileHandler.flush();
            fileHandler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * This takes a log record and create a string to be logged by the logger
     * @param record
     * @return
     *
     */
    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1024);
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }
}
