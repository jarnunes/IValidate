package com.ivalidate.model;

import org.junit.Test;
import org.junit.Assert;
import com.ivalidate.model.cpf.CpfValidate;

/****
 * @author Jardel Nunes
 * Classe de testes unitários para a validação de CPF
 */
public class CpfValidateTest {
    private final String SEQUENCE_CPF = "11111111111";
    private final String INVALID_CPF = "111.111.111-11";
    private final String VALID_CPF = "524.237.730-56";
    private final String CLEAN_CPF = "52423773056";
    private final String INVALID_DIGIT = "524.237.730-56a";

    @Test
    public void testClearCPF() {
        Assert.assertEquals(CLEAN_CPF, CpfValidate.clear(VALID_CPF));
    }

    @Test
    public void testIsSequenceMethod() {
        // TODO verficar nos 10 mandamentos de testes se pode haver mais de um assert em um unico metodo
        Assert.assertTrue(CpfValidate.isSequence(SEQUENCE_CPF));
        Assert.assertTrue(CpfValidate.isSequence(INVALID_CPF));
    }

    @Test
    public void testCalcModule() {
        Assert.assertEquals(3, CpfValidate.calcModule(162));
    }

    @Test
    public void testCalcFirstDigit() {
        long FIRST_VALID_SEQ = 111444777;
        Assert.assertEquals(3, CpfValidate.calcFirstSecDigit(FIRST_VALID_SEQ, 1));
    }

    @Test
    public void testCalcSecDigit() {
        long SECOND_VALID_SEQ = 1114447773;
        Assert.assertEquals(5, CpfValidate.calcFirstSecDigit(SECOND_VALID_SEQ, 1));
    }


    @Test
    public void testValidateSequence() {
        Assert.assertFalse(CpfValidate.validate(SEQUENCE_CPF));
    }

    @Test
    public void testInvalidCPF() {
        Assert.assertFalse(CpfValidate.validate(INVALID_CPF));
    }

    @Test
    public void testValidCPF() {
        Assert.assertTrue(CpfValidate.validate(VALID_CPF));
    }

    @Test
    public void testCleanValidCPF() {
        Assert.assertTrue(CpfValidate.validate(CLEAN_CPF));
    }

    @Test
    public void testInvalidCharacter() {
        Assert.assertTrue(CpfValidate.containsInvalidDigits(INVALID_DIGIT));
    }
}