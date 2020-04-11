package base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	public static String username = null;
    public static String password = null;
    public static String baseUrl = null;
    private String propFileName = "app.properties";

    public Config() {
        Properties prop = new Properties();

        try {
            InputStream inputStream = new FileInputStream(Constants.properties_path + propFileName);
            	prop.load(inputStream);
       
                username = prop.getProperty("username");
                password = prop.getProperty("password");
                baseUrl = prop.getProperty("baseUrl");
     
        } catch (Exception e) {
            System.out.println("Exception stack trace.. " + e);
        }
    }
}