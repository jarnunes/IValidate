package com.ivalidate.model;

import org.junit.Test;
import org.junit.Assert;
import com.ivalidate.model.cpf.CPFValidate;

/*
 * TDD - Test Driven Development
 * 1 - Cria-se os testes da funcionalidade. Estes são chamados de testes falhos, pois a funcionalidade ainda não existe, desta forma, ao serem executados retornarão erro.
 * 2 - Desenvolve-se o código para fazer com que o teste seja executado, já que o desenvolvedor sabe quais funcionalidades deve implementar, fica mais prático o seu desenvolvimento.
 * 3 - Por fim refatorar, ou seja, melhorar a codificação.
 *  */
public class CPFValidateTest {
    private final String SEQUENCE_CPF = "11111111111";
    private final String INVALID_CPF = "111.111.111-11";
    private final String INVALID_FORMAT_CPF = "111.111.";
    private final String VALID_CPF = "524.237.730-56";
    private final String CLEAN_CPF = "52423773056";

    @Test
    private void testValidateSequence() {
        Assert.assertTrue(CPFValidate.validate(SEQUENCE_CPF));
    }

    @Test
    private void testValidateInvalid() {
        Assert.assertTrue(CPFValidate.validate(INVALID_CPF));
    }

    @Test
    private void testValidCPF() {
        Assert.assertTrue(CPFValidate.validate(VALID_CPF));
    }

    @Test
    private void testCleanValidCPF() {
        Assert.assertTrue(CPFValidate.validate(CLEAN_CPF));
    }

    @Test
    private void testClearCPF() {
        Assert.assertEquals(CLEAN_CPF, CPFValidate.clear(VALID_CPF));
    }


}

