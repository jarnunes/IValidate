package com.ivalidate.model;

import org.junit.Test;
import org.junit.Assert;
import com.ivalidate.model.cpf.CPFValidate;

public class CPFValidateTest {
    private final String SEQUENCE_CPF = "111.111.111-11";
    private final String INVALID_CPF = "111.111.111-11";
    private final String INVALID_FORMAT_CPF = "111.111.";
    private final String VALID_CPF = "524.237.730-56";
    private final String CLEAN_CPF = "52423773056";

    @Test
    public void inputValidateTest() {

    }

    @Test
    private void clearCPF() {
        // Assert.assertEquals(CLEAN_CPF, CPFValidate.clear(VALID_CPF));
    }

    @Test
    private void isSequenceTest() {
        //Assert.assertTrue(CPFValidate.isSequence(SEQUENCE_CPF));
    }
}
