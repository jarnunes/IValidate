/// <reference types="Cypress" />

Cypress.Commands.add('validateCPF', (cpf) =>{
    cy.visit('/')
    cy.get('div table tbody tr td input').type(cpf)
    cy.get('button[type="submit"]').contains('Validar').click()
})
Cypress.Commands.add('validateCPFNaoInformado', () =>{
    cy.visit('/')
    cy.get('button[type="submit"]').contains('Validar').click()
})

Cypress.Commands.add('generateCPF', () =>{
    cy.visit('/')
    cy.get('div ul li a').contains('Gerar CPF').click()
    cy.get('div div button span').contains('Gerar').click()
    cy.get('div div input').invoke('val').should('not.be.empty')
})