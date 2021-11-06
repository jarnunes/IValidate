package com.ivalidate.model;

import java.util.concurrent.ThreadLocalRandom;
import java.util.Locale;
import java.util.Objects;


public class GenerateBase {

    /***
     *
     * @param numDigits numero de digitos que o identificador deve possuir. CPF:11...
     * @return valores base em formato string para geração da sequência
     */
    public static String generateBase(int numDigits) {
        return String.valueOf(ThreadLocalRandom.current()
                .nextLong(calcMinMaxValue(numDigits - 2, "min"), calcMinMaxValue(numDigits - 2, "max")));
    }

    private static long calcMinMaxValue(int numDigits, String op) {
        if (Objects.equals(op.toLowerCase(Locale.ROOT), "min"))
            return (long) Math.pow(10, numDigits - 1);
        if (Objects.equals(op.toLowerCase(Locale.ROOT), "max"))
            return (long) Math.pow(10, numDigits) - 1;
        return 0;
    }

}
