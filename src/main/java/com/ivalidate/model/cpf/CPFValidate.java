package com.ivalidate.model.cpf;


public class CPFValidate {
    private final int FIRST_DIGIT_LENGTH = 10;
    private final int SEC_DIGIT_LENGTH = 11;
    private final int CAL_DIGIT_LIMIT = 2;

    public static boolean validate(String cpf) {
        return false;
    }

    public static long clear(String cpf) {
        try {
            return Integer.parseInt(cpf.replaceAll("[0-9]", ""));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private boolean isSequence(String cpf) {
        int counter = 0;
        for (int i = 0; i < cpf.length(); i++) {
            if (cpf.charAt(0) == i) counter++;
        }
        if (counter == cpf.length()) return true;

        return false;
    }

    private int calcFirstDigit(int preCPF) {
        String tmp = String.valueOf(preCPF);
        int calc = 0;
        try {
            for (int i = FIRST_DIGIT_LENGTH; i >= CAL_DIGIT_LIMIT; i--) {
                calc += tmp.charAt(i) * i;
            }
            return calc;
        } catch (Exception e) {
            return 0;
        }
    }


    private int calcSecDigit(int cpf) {
        String tmp = String.valueOf(cpf);
        int calc = 0;
        try {
            for (int i = SEC_DIGIT_LENGTH; i >= CAL_DIGIT_LIMIT; i--) {
                calc += tmp.charAt(i) * i;
            }
            return calc;
        } catch (Exception e) {
            return 0;
        }
    }


    private int calcModule(int calDigit) {
        int remainder = calDigit % 11;
        return (remainder < 2) ? 0 : 11 - remainder;
    }


}
