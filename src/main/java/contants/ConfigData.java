package contants;

import helpers.PropertiesHelper;

public class ConfigData {
    public static String AUTHOR = PropertiesHelper.getValue("AUTHOR");
    public static String FRAMEWORK = PropertiesHelper.getValue("FRAMEWORK");

    public static String URL = PropertiesHelper.getValue("URL");
    public static String EMAIL = PropertiesHelper.getValue("EMAIL");
    public static String PASSWORD = PropertiesHelper.getValue("PASSWORD");

    public static String HEADLESS = PropertiesHelper.getValue("HEADLESS");

    public static int TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("TIMEOUT"));
    public static int STEP_TIME = Integer.parseInt(PropertiesHelper.getValue("STEP_TIME"));
    public static int PAGE_LOAD_TIMEOUT = Integer.parseInt(PropertiesHelper.getValue("PAGE_LOAD_TIMEOUT"));
    public static String EXTENT_REPORT = PropertiesHelper.getValue("EXTENT_REPORT");

    public static String SCREENSHOT = PropertiesHelper.getValue("SCREENSHOT");
    public static String SCREENSHOT_PATH = PropertiesHelper.getValue("SCREENSHOT_PATH");
    public static String RECORD = PropertiesHelper.getValue("RECORD");
    public static String RECORD_PATH = PropertiesHelper.getValue("RECORD_PATH");

    public static String FILE_EXCEL = PropertiesHelper.getValue("FILE_EXCEL");
}
