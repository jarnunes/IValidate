package com.ivalidate.model;

import com.ivalidate.model.cnpj.CnpjValidate;
import org.junit.Test;
import org.junit.Assert;


public class CnpjValidateTest {

    @Test
    public void testCalcFirstDigit() {
        Assert.assertEquals(CnpjValidate.calcDigit(112223330001L, 1), 8);
    }

    @Test
    public void testCalcSecDigit() {
        Assert.assertEquals(CnpjValidate.calcDigit(1122233300018L, 2), 1);
    }

    @Test
    public void testValidateCnpj() {

        Assert.assertTrue(CnpjValidate.validate("11.222.333/0001-81"));

    }

    @Test
    public void testCleanvalidCnpj() {
        Assert.assertTrue(CnpjValidate.validate("11222333000181"));
    }

    @Test
    public void testInvalidCnpj() {

        Assert.assertFalse(CnpjValidate.validate("11.222.333/0001-88"));
    }
    @Test
    public void testIsSequence() {

        Assert.assertFalse(CnpjValidate.validate("11111111111111"));
    }


    @Test
    public void testCleanInvalidCnpj() {

        Assert.assertFalse(CnpjValidate.validate("11222333000188"));
    }

    @Test
    public void testNoneCnpj() {

        Assert.assertFalse(CnpjValidate.validate(""));
    }
}
