package com.ivalidate.model;

import org.apache.commons.lang3.StringUtils;

public class ValidateBase {

    public static boolean isSequence(String identity) {
        identity = clear(identity);
        int counter = 0;
        int aux = Integer.parseInt(String.valueOf(identity.charAt(0)));

        for (int i = 0; i < identity.length(); i++) {
            if (aux == Integer.parseInt(String.valueOf(identity.charAt(i)))) counter++;
        }
        return counter == identity.length();
    }

    public static String clear(String identity) {
        return identity.replaceAll("[^0-9]", "");
    }

    public static int calcModule(int calDigit) {
        int remainder = calDigit % 11;
        return (remainder < 2) ? 0 : 11 - remainder;

    }

    public static String removeLastDigits(String cpf) {
        return StringUtils.substring(cpf, 0, -2);
    }


}
