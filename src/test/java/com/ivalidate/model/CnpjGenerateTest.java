package com.ivalidate.model;

import com.ivalidate.model.cnpj.CnpjGenerate;
import com.ivalidate.model.cnpj.CnpjValidate;
import org.junit.Test;
import org.junit.Assert;

public class CnpjGenerateTest {

    @Test
    public void testeGenerateBaseCnpj() {
        Assert.assertEquals(12, CnpjGenerate.generateBase(14).length());
    }

    @Test
    public void testIsValid() {
        Assert.assertTrue(CnpjValidate.validate(CnpjGenerate.generate()));
    }
}
