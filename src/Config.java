import java.util.Properties;

/**
 * Reads in a config file called "config.cfg"
 */
public class Config {

    private Properties config;

    /**
     * Constructor gets file and reads data
     */
    public Config() {
        config = new java.util.Properties();
        try {
            config.load(this.getClass().getClassLoader().getResourceAsStream("config.cfg"));
        } catch (Exception eta) {
            eta.printStackTrace();
        }
    }

    /**
     * Returns a key value pair of a property
     *
     * @param key
     * @return
     */
    public int getProperty(String key) {
        return Integer.parseInt(this.config.getProperty(key));
    }
}
