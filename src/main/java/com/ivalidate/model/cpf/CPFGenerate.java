package com.ivalidate.model.cpf;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.ivalidate.model.cpf.CPFValidate;

public class CPFGenerate {
    private static final long MIN = 100000000;
    private static final long MAX = 999999999;

    public static String generateBase() {
        return String.valueOf(ThreadLocalRandom.current().nextLong(MIN, MAX));
    }

    public static String generateCPF() {
        String tmp = generateBase();
        tmp += CPFValidate.calcFirstDigit(Long.parseLong(tmp));
        tmp += CPFValidate.calcSecDigit(Long.parseLong(tmp));
        return tmp;
    }

}
