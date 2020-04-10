package base;

public class Constants {
	
	public static final String user_dir = System.getProperty("user.dir");
	public static final String user_home = System.getProperty("user.home");
    public static final String separator = System.getProperty("file.separator");
    public static final String properties_path;
    public static final String chromeDriver_path;
    public static final String firefoxDriver_path;
	
    public Constants() {
    }
    
    static {
    	properties_path = user_dir + separator;
    	chromeDriver_path = user_dir + separator + "drivers" + separator;
    	firefoxDriver_path= user_dir + separator + "drivers" + separator;
    }
    
    public static void main(String[] args) {
		System.out.println(chromeDriver_path);
	}
}
