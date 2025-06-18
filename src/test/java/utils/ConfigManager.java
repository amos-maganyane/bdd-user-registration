package utils;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final String DEFAULT_CONFIG_FILE = "/test.properties";
    private static final Properties props = new Properties();

    static {
        try {
            String configFile = System.getProperty("config.file", DEFAULT_CONFIG_FILE);
            props.load(ConfigManager.class.getResourceAsStream(configFile));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load test properties", e);
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static String getBaseUrl() {
        return props.getProperty("api.base.url");
    }
}
