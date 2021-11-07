package com.ivalidate.model.cpf;

import com.ivalidate.model.base.GenerateBase;

public class CpfGenerate extends GenerateBase {
    private static final int NUM_DIGITS = 11;


    public static String generateCPF() {
        String tmp = generateBase(NUM_DIGITS);
        tmp += CpfValidate.calcFirstSecDigit(Long.parseLong(tmp), 1);
        tmp += CpfValidate.calcFirstSecDigit(Long.parseLong(tmp), 2);
        return tmp;
    }
}
