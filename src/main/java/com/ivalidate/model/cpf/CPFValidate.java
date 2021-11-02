package com.ivalidate.model.cpf;

import org.apache.commons.lang3.StringUtils;

public class CPFValidate {
    private static int FIRST_DIGIT_LENGTH = 10;
    private static int SEC_DIGIT_LENGTH = 11;
    private static int CAL_DIGIT_LIMIT = 2;

    public static boolean isValid(String cpf) {
        cpf = clear(cpf);
        if (!isSequence(cpf)) {
            String tmp = removeLastDigits(cpf);
            tmp += String.valueOf(calcFirstDigit(Long.parseLong(tmp)));
            tmp += String.valueOf(calcSecDigit(Long.parseLong(tmp)));
            return cpf.equals(tmp);
        }
        return false;
    }

    public static String clear(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }

    public static String removeLastDigits(String cpf) {
        return StringUtils.substring(cpf, 0, -2);
    }

    public static boolean isSequence(String cpf) {
        cpf = clear(cpf);
        int counter = 0;
        int aux = Integer.parseInt(String.valueOf(cpf.charAt(0)));

        for (int i = 0; i < cpf.length(); i++) {
            if (aux == Integer.parseInt(String.valueOf(cpf.charAt(i)))) counter++;
        }
        if (counter == cpf.length()) return true;

        return false;
    }

    public static long calcFirstDigit(long preCPF) {

        int calc = 0, init = 0;
        try {
            for (int i = CAL_DIGIT_LIMIT; i <= FIRST_DIGIT_LENGTH; i++) {
                calc += (preCPF % 10) * i;
                preCPF = (long) preCPF / 10;
            }
            return calcModule(calc);
        } catch (Exception e) {
            return -1;
        }
    }


    public static long calcSecDigit(long cpf) {
        int calc = 0;
        try {
            for (int i = CAL_DIGIT_LIMIT; i <= SEC_DIGIT_LENGTH; i++) {
                calc += (cpf % 10) * i;
                cpf = (long) cpf / 10;
            }
            return calcModule(calc);
        } catch (Exception e) {
            return -1;
        }
    }


    public static int calcModule(int calDigit) {
        int remainder = calDigit % 11;
        return (remainder < 2) ? 0 : 11 - remainder;

    }
}
