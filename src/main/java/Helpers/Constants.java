package Helpers;

public class Constants {
    public static final int DEFAULT_TIMEOUT = 10;
    public static String brandName = "Apple";


    public static String registerTransformer (String s){
        return s.substring(0,1).toUpperCase() + s.substring(1).toLowerCase();
    }
}
