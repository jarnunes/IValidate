package com.ivalidate.model.cpf;

import com.ivalidate.model.base.CalcBaseDigits;
import com.ivalidate.model.base.ValidateBase;
import com.ivalidate.model.utils.ClearIdentity;

public class CpfValidate extends ValidateBase {
    private static final int CAL_DIGIT_LIMIT = 2;

    public static boolean validate(String cpf) {
        if (cpf.length() < 11) return false;
        cpf = ClearIdentity.clear(cpf);
        if (isValidBase(cpf)) {
            String tmp = ClearIdentity.removeLastDigits(cpf);
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
            return CalcBaseDigits.calcModule(calc);
        } catch (Exception e) {
            return -1;
        }
    }
}
