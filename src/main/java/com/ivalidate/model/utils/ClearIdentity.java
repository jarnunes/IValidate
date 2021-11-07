package com.ivalidate.model.utils;

import org.apache.commons.lang3.StringUtils;

public class ClearIdentity {
    public static String clear(String identity) {
        return identity.replaceAll("[./-]", "");
    }

    public static String removeLastDigits(String idendity) {
        return StringUtils.substring(idendity, 0, -2);
    }

    public static String removeLastDigits(String idendity, int numDigitsToRemove) {
        return StringUtils.substring(idendity, 0, -2);
    }
}
