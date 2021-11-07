package com.ivalidate.model.base;


public class CalcBaseDigits {
    public static int calcModule(int calDigit) {
        int r = calDigit % 11;
        return (r < 2) ? 0 : 11 - r;
    }
}
