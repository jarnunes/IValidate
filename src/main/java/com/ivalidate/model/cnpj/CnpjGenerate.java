package com.ivalidate.model.cnpj;

import com.ivalidate.model.GenerateBase;
import com.ivalidate.model.cpf.CpfValidate;

public class CnpjGenerate extends GenerateBase {
    private static final int NUM_DIGITS = 14;

    public static String generate() {
        String tmp = generateBase(NUM_DIGITS);
        tmp += CnpjValidate.calcDigit(Long.parseLong(tmp), 1);
        tmp += CnpjValidate.calcDigit(Long.parseLong(tmp), 2);
        return tmp;
    }
}
