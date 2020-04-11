package base;

import org.apache.log4j.PropertyConfigurator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

public class Configs {

	public static String chromeDriverPath;
	public static String firefoxDriverPath;
	public static String ieDriverPath;
	public static String edgeDriverPath;
	public static String applicationURL;
	public static InputStream inputStream;
	private static String propFileName = "app.properties";
	static Logger log = Logger.getLogger(Configs.class);

	private Configs() {
	}
	
	/**
	 * This method will read the app.properties file and will initialize the
	 * following variables ExtentReportsPath, ReportTitle, ReportName,
	 * ScreenShotsPath, ChromeDriverPath, FirefoxDriverPath, IEDriverPath, ExcelResourceDir, ApplicationURL
	 */
	
	public static void initConfigs() {
		PropertyConfigurator.configure("log4j.properties");

		log.info(": initConfigs called");
		String path = Constants.properties_path + propFileName;
		Properties prop = new Properties();

		try {
			inputStream = new FileInputStream(path);
			if (inputStream != null) {
				prop.load(inputStream);
				chromeDriverPath= Constants.chromeDriver_path+"chromedriver.exe";
				firefoxDriverPath= Constants.firefoxDriver_path+"geckodriver.exe";
				applicationURL = prop.getProperty("applicationURL");
			}

		} catch (IOException e) {
			System.err.println("Cannot find the app.properties file at " + path);
			log.error(e.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					System.err.println("Cannot close the app.properties file instance.");
					log.error(e.getMessage());
				}
			}
		}

	}
}