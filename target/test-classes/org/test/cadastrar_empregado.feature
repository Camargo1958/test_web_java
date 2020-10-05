Feature: Cadastrar novo empregado

  Scenario: Acessar a tela de Cadastramento de novo empregado com sucesso
    Given Eu realize o login com sucesso com as credenciais "nelson.rodrigues@test.xx" e "123456"
    And O sistema apresentar a tela do Cadastro de "empregados"
    When Eu selecionar o item "NOVO FUNCIONÁRIO" no menu
    Then O sistema apresentara a tela de cadastramento de novo empregado


  Scenario: Cadastrar novo empregado CLT com sucesso
    Given Eu realize o login com sucesso com as credenciais "nelson.rodrigues@test.xx" e "123456"
    And Eu acesse o cadastramento de novo empregado
    When Eu inserir "Jonas Mello" no campo de "Nome"
    And Eu inserir "998.089.670-19" no campo de "CPF"
    And Eu inserir "22/02/2020" no campo de "Admissão"
    And Eu inserir "Terapeuta" no campo de "Cargo"
    And Eu inserir "10000,00" no campo de "Salário"
    And Eu selecionar "CLT" para o "Tipo de Contratação"
    And Eu selecionar "Masculino" para o "Sexo"
    And Eu acionar o botao "Enviar"
    Then O sistema apresentara a tela de cadastramento de novo empregado
    And O sistema mostrara uma mensagem de "SUCESSO" no cadastramento

  Scenario: Cadastrar novo empregado PJ com sucesso
    Given Eu realize o login com sucesso com as credenciais "nelson.rodrigues@test.xx" e "123456"
    And Eu acesse o cadastramento de novo empregado
    When Eu inserir "Karina Mello" no campo de "Nome"
    And Eu inserir "198.928.470-16" no campo de "CPF"
    And Eu inserir "25/03/2001" no campo de "Admissão"
    And Eu inserir "Massagista" no campo de "Cargo"
    And Eu inserir "15000,00" no campo de "Salário"
    And Eu selecionar "PJ" para o "Tipo de Contratação"
    And Eu selecionar "Feminino" para o "Sexo"
    And Eu acionar o botao "Enviar"
    Then O sistema apresentara a tela de cadastramento de novo empregado
    And O sistema mostrara uma mensagem de "SUCESSO" no cadastramento