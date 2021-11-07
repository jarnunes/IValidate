package com.ivalidate.model.cnpj;

import com.ivalidate.model.base.CalcBaseDigits;
import com.ivalidate.model.base.ValidateBase;
import com.ivalidate.model.utils.ClearIdentity;

public class CnpjValidate extends ValidateBase {
    private static final int CAL_DIGIT_LIMIT = 2;

    public static long calcDigit(long preCnpj, int indDigit) {
        int calc = 0;

        int[] sequence = (indDigit == 1) ? new int[]{5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2} : new int[]{6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
        try {
            for (int j = sequence.length - 1; j >= 0; j--) {
                calc += (preCnpj % 10) * sequence[j];
                preCnpj = preCnpj / 10;
            }
            return CalcBaseDigits.calcModule(calc);
        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean validate(String cnpj) {
        if (cnpj.length() < 11) return false;

        cnpj = ClearIdentity.clear(cnpj);

        if (isValidBase(cnpj)) {
            String tmp = ClearIdentity.removeLastDigits(cnpj);
            tmp += String.valueOf(calcDigit(Long.parseLong(tmp), 1));
            tmp += String.valueOf(calcDigit(Long.parseLong(tmp), 2));
            return cnpj.equals(tmp);
        }
        return false;
    }
}
