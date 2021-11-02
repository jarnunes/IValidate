package com.ivalidate.model;


import com.ivalidate.model.cpf.CPFGenerate;
import com.ivalidate.model.cpf.CPFValidate;
import org.junit.Test;
import org.junit.Assert;


public class CPFGenerateTest {

    @Test
    public void testeGenerateBase() {
        Assert.assertEquals(CPFGenerate.generateBase().length(), 9);
    }

    @Test
    public void testGenerateValidSequence() {
        String cpf = CPFGenerate.generateCPF();
        Assert.assertTrue(CPFValidate.validate(cpf));
    }
}
