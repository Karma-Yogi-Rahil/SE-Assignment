package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        String propFileName = "/config.properties";  // Assuming this file is in the classpath root
        try (InputStream inputStream = ConfigLoader.class.getResourceAsStream(propFileName)) {
            if (inputStream == null) {
                throw new RuntimeException("Property file '" + propFileName + "' not found in the classpath");
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load property file '" + propFileName + "'", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static int getIntProperty(String key) {
        try {
            return Integer.parseInt(properties.getProperty(key));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Property for '" + key + "' is not an integer or not found.");
        }
    }
}
