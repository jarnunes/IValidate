package com.ivalidate.model;

import org.junit.Test;
import org.junit.Assert;
import com.ivalidate.model.cpf.CPFValidate;

/****
 * @author Jardel Nunes
 * Classe de testes unitários para a validação de CPF
 */
public class CPFValidateTest {
    private final String SEQUENCE_CPF = "11111111111";
    private final String INVALID_CPF = "111.111.111-11";
    private final String INVALID_FORMAT_CPF = "111.111.";
    private final String VALID_CPF = "524.237.730-56";
    private final String CLEAN_CPF = "52423773056";
    private final long FIRST_VALID_SEQ = 111444777;
    private final long SECOND_VALID_SEQ = 1114447773;

    @Test
    public void testClearCPF() {
        Assert.assertEquals(CLEAN_CPF, CPFValidate.clear(VALID_CPF));
    }

    @Test
    public void testIsSequenceMethod() {
        // TODO verficar nos 10 mandamentos de testes se pode haver mais de um assert em um unico metodo
        Assert.assertTrue(CPFValidate.isSequence(SEQUENCE_CPF));
        Assert.assertTrue(CPFValidate.isSequence(INVALID_CPF));
    }

    @Test
    public void testCalcModule() {
        Assert.assertEquals(3, CPFValidate.calcModule(162));
    }

    @Test
    public void testCalcFirstDigit() {
        Assert.assertEquals(3, CPFValidate.calcFirstDigit(FIRST_VALID_SEQ));
    }

    @Test
    public void testCalcSecDigit() {
        Assert.assertEquals(5, CPFValidate.calcSecDigit(SECOND_VALID_SEQ));
    }


    @Test
    public void testValidateSequence() {
        Assert.assertFalse(CPFValidate.validate(SEQUENCE_CPF));
    }

    @Test
    public void testInvalidCPF() {
        Assert.assertFalse(CPFValidate.validate(INVALID_CPF));
    }

    @Test
    public void testValidCPF() {
        Assert.assertTrue(CPFValidate.validate(VALID_CPF));
    }

    @Test
    public void testCleanValidCPF() {
        Assert.assertTrue(CPFValidate.validate(CLEAN_CPF));
    }

}

