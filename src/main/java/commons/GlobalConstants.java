package commons;

import utilities.DataFakerHelper;

import java.io.File;

public class GlobalConstants {
    public static final String EMAIL_ADDRESS = DataFakerHelper.getDataFakerHelper().getEmailAddress();
    public static final String PASSWORD = "123456";
    public static final String USER_HOME_PAGE_URL = "https://demo.nopcommerce.com/";
    public static final String USER_LOGIN_PAGE_URL = "https://demo.nopcommerce.com/login?";
    public static final String ADMIN_HOME_PAGE_URL = "https://admin-demo.nopcommerce.com/login?";
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String JAVA_VERSION = System.getProperty("java.version");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;
    public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";
    public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";
    public static final String DB_DEV_URL = "";
    public static final String DB_DEV_USER = "";
    public static final String DB_DEV_PASS = "";
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 30;
    public static final long RETRY_TEST_FAIL = 3;
}
