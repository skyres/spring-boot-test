package com.example.app1.util;

public class StringUtils {

    public static String emptyString() {
        return "";
    }

    public static boolean isNull(String str) {
        return str == null;
    }

    public static boolean isEmpty(String str) {
        return isNull(str) || isEqual(str, emptyString());
    }

    public static boolean isEqual(String str1, String str2) {
        return isEqual(str1, str2, true);
    }

    public static boolean isEqual(String str1, String str2, boolean isCaseSensitive) {
        return (isNull(str1) && isNull(str2))
                || (!isNull(str1) && !isNull(str2)
                    && (isCaseSensitive && str1.equalsIgnoreCase(str2))
                        || (!isCaseSensitive && str1.equals(str2)));
    }



}
