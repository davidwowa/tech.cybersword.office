package tech.cybersword;

import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(
                    "Usage: java -jar tech.cybersword.office-*.jar <test name> <target path> <source path> <file endings> <setExif true|false> <use glitch true|false>");
            System.exit(1);
        }

        if (logger.isInfoEnabled()) {
            logger.info("Starting application...");
        }

        String testName = args[0] + "_" + getCurrentDate();
        String targetPath = args[1];
        String sourcePath = args[2];
        String fileEndings = args[3];
        Boolean setExif = Boolean.parseBoolean(args[4]);
        Boolean useGlitch = Boolean.parseBoolean(args[5]);

        DirectoryReader payloadReader = new DirectoryReader(sourcePath, fileEndings);
        Map<String, String> payloads = payloadReader.readTxtFilesToHashMap();

        if (payloads != null && payloads.size() > 0) {
            Set<String> keys = payloads.keySet();
            for (String key : keys) {
                if (null != key && key.length() > 0) {

                    String toAdd = payloads.get(key);

                    if (logger.isInfoEnabled()) {
                        logger.info(String.format("%s -> %s", key, toAdd));
                    }

                    // next here
                }
            }
        }
    }

    public static String getCurrentDate() {
        return new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
    }
}