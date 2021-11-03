/// <reference types="Cypress" />

describe('CT001 - Validar CPF', () => {
    const cpf_valido = '37989106000'
    const cpf_invalido = '02031478549'
    it('CPF Válido', () => {
        cy.validateCPF(cpf_valido);
        cy.get('div div ul li span').should('contain', `CPF ${cpf_valido} é válido.`)
    });
    it('CPF Não Informado', () => {
        cy.validateCPFNaoInformado();
        cy.get('div div ul li span').should('contain', `ERRO! Campo obrigatório`);
    });
    it('CPF Inválido', () => {
        cy.validateCPF(cpf_invalido);
        cy.get('div div ul li span').should('contain', `CPF Inválido`);
    });

});

describe('CT002 - Gerar CPF', () => {
    it('Gerar CPF', () => {
        cy.generateCPF()
    })
})
