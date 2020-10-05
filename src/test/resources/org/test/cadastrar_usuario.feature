Feature: Cadastrar usuario

  Scenario: Abrir a tela de cadastramento
    Given Eu esteja na pagina inmrobo.tk
    When Eu selecionar o link "Cadastre-se"
    Then O sistema ira para a tela de cadastramento
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Cadastrar corretamente um novo usuario
    Given Eu esteja na tela de cadastramento
    When Eu fornecer o nome do usuario como "nelson.rodrigues@test.bc"
    And Eu fornecer a senha do usuario como "123458"
    And Eu confirmar a senha do usuario como "123458"
    And Eu selecionar o botao "Cadastrar"
    Then O sistema ira para a tela de Login
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Tentar cadastrar um usuario com nome em branco
    Given Eu esteja na tela de cadastramento
    When Eu fornecer o nome do usuario como ""
    And Eu fornecer a senha do usuario como "123458"
    And Eu confirmar a senha do usuario como "123458"
    And Eu selecionar o botao "Cadastrar"
    Then O sistema emitira um alerta de erro no campo de Usuario
    And O sistema permanecera na tela de "Cadastramento"
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Tentar cadastrar um usuario com senha idefinida
    Given Eu esteja na tela de cadastramento
    When Eu fornecer o nome do usuario como "peter.coyote@test.br"
    And Eu fornecer a senha do usuario como ""
    And Eu confirmar a senha do usuario como ""
    And Eu selecionar o botao "Cadastrar"
    Then O sistema emitira um alerta de erro no campo de Senha
    And O sistema permanecera na tela de "Cadastramento"
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Tentar cadastrar um usuario com senha discrepante
    Given Eu esteja na tela de cadastramento
    When Eu fornecer o nome do usuario como "peter.coyote@test.xx"
    And Eu fornecer a senha do usuario como "12345"
    And Eu confirmar a senha do usuario como "12346"
    And Eu selecionar o botao "Cadastrar"
    Then O sistema emitira a mensagem "Senhas não combinam"
    And O sistema permanecera na tela de "Cadastramento"
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Tentar cadastrar um usuario já cadastrado
    Given Eu esteja na tela de cadastramento
    When Eu fornecer o nome do usuario como "nelson.rodrigues@test.xx"
    And Eu fornecer a senha do usuario como "123456"
    And Eu confirmar a senha do usuario como "123456"
    And Eu selecionar o botao "Cadastrar"
    Then O sistema mostrara a mensagem "Usuário já cadastrado"
    And O sistema permanecera na tela de "Cadastramento"
    And Eu fecho o aplicativo encerrando o teste