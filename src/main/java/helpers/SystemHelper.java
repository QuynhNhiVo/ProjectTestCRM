package helpers;

import java.io.File;

public class SystemHelper {
    public static String getCurrentDir(){
        String path = System.getProperty("user.dir") + File.pathSeparator;
        return path;
    }
}
