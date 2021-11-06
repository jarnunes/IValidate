package com.ivalidate.model.cpf;

import com.ivalidate.model.ValidateBase;

public class CpfValidate extends ValidateBase {
    private static final int CAL_DIGIT_LIMIT = 2;

    public static boolean validate(String cpf) {
        if (cpf.length() < 11) return false;

        cpf = clear(cpf);
        if (!isSequence(cpf) && !containsInvalidDigits(cpf)) {
            String tmp = removeLastDigits(cpf);
            tmp += String.valueOf(calcFirstSecDigit(Long.parseLong(tmp), 1));
            tmp += String.valueOf(calcFirstSecDigit(Long.parseLong(tmp), 2));
            return cpf.equals(tmp);
        }
        return false;
    }


    public static long calcFirstSecDigit(long preCPF, int indDigit) {
        int calc = 0;
        int sequence = (indDigit == 1) ? 10 : 11;
        try {
            for (int i = CAL_DIGIT_LIMIT; i <= sequence; i++) {
                calc += (preCPF % 10) * i;
                preCPF = preCPF / 10;
            }
            return calcModule(calc);
        } catch (Exception e) {
            return -1;
        }
    }

}
