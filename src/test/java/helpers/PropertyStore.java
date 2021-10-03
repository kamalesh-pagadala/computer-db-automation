package helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyStore {

    private static PropertyStore myPropertyStore;


    public String currentPath = System.getProperty("user.dir");
    public Properties prop = new Properties();
    public String value;

    public static PropertyStore getInstance() {
        if (myPropertyStore == null) {
            myPropertyStore = new PropertyStore();
        }
        return myPropertyStore;
    }

    public String getProperty(String key) {
        try {

            InputStream input = new FileInputStream(currentPath + "/src/main/java/configs/configLocal.properties");
            prop.load(input);
            value = prop.getProperty(key);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        return value;
    }

}
