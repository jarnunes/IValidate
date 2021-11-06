package com.ivalidate.model.cnpj;

import com.ivalidate.model.ValidateBase;

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
            return calcModule(calc);

        } catch (Exception e) {
            return -1;
        }
    }

    public static boolean validate(String cnpj) {
        if (cnpj.length() < 11) return false;

        cnpj = clear(cnpj);
        if (!isSequence(cnpj)) {
            String tmp = removeLastDigits(cnpj);
            tmp += String.valueOf(calcDigit(Long.parseLong(tmp), 1));
            tmp += String.valueOf(calcDigit(Long.parseLong(tmp), 2));
            return cnpj.equals(tmp);
        }
        return false;
    }
}
