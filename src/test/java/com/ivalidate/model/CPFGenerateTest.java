package com.ivalidate.model;


import com.ivalidate.model.cpf.CPFGenerate;
import org.junit.Test;
import org.junit.Assert;
import com.ivalidate.model.cpf.CPFValidate;

public class CPFGenerateTest {

    @Test
    public void testeGenerateBase(){
        Assert.assertEquals(CPFGenerate.generateBase().length(), 9 );
    }

    @Test
    public void testGenerateValidSequence(){
        String cpf = CPFGenerate.generateValidSequence();
        Assert.assertTrue(CPFValidate.validate(cpf));
    }
}
