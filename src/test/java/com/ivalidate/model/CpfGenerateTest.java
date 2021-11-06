package com.ivalidate.model;


import com.ivalidate.model.cpf.CpfGenerate;
import com.ivalidate.model.cpf.CpfValidate;
import org.junit.Test;
import org.junit.Assert;


public class CpfGenerateTest {

    @Test
    public void testeGenerateBase() {
        Assert.assertEquals(9, CpfGenerate.generateBase(11).length());
    }

    @Test
    public void testGenerateValidSequence() {
        Assert.assertTrue(CpfValidate.validate(CpfGenerate.generateCPF()));
    }
}
