import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LoggerFormatter extends Formatter {
    static Logger logger = Logger.getLogger(LoggerFormatter.class.getName());
    FileHandler fileHandler;
    public void log(String msg){
        try{
            fileHandler = new FileHandler("simulator.txt", true);
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

    public String format(LogRecord record) {
        StringBuilder builder = new StringBuilder(1024);
//        builder.append(record.getSourceClassName());
        builder.append(formatMessage(record));
        builder.append("\n");
        return builder.toString();
    }
}
