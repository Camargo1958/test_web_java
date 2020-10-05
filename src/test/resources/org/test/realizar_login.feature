Feature: Realizar login de usuario

  Scenario: Realizar login com sucesso
    Given Eu esteja na pagina inmrobo.tk
    When Eu fornecer o nome do usuario como "nelson.rodrigues@test.xx"
    And Eu fornecer a senha do usuario como "123456"
    And Eu selecionar o botao "Entre"
    Then O sistema ira para a tela do Cadastro de "empregados"
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Tentar realizar login com senha incorreta
    Given Eu esteja na pagina inmrobo.tk
    When Eu fornecer o nome do usuario como "nelson.rodrigues@test.xx"
    And Eu fornecer a senha do usuario como "12345"
    And Eu selecionar o botao "Entre"
    Then O sistema permanecera na tela de "Login"
    And O sistema mostrara a mensagem "ERRO! Usuário ou Senha inválidos"
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Tentar realizar login com usuario não cadastrado
    Given Eu esteja na pagina inmrobo.tk
    When Eu fornecer o nome do usuario como "john.wayne@test.xx"
    And Eu fornecer a senha do usuario como "12345"
    And Eu selecionar o botao "Entre"
    Then O sistema permanecera na tela de "Login"
    And O sistema mostrara a mensagem "ERRO! Usuário ou Senha inválidos"
    And Eu fecho o aplicativo encerrando o teste

  Scenario: Tentar realizar login com nome de usuario indefinido
    Given Eu esteja na pagina inmrobo.tk
    When Eu fornecer o nome do usuario como ""
    And Eu fornecer a senha do usuario como "12345"
    And Eu selecionar o botao "Entre"
    Then O sistema permanecera na tela de "Login"
    And O sistema emitira um alerta de erro no campo de Usuario
    And Eu fecho o aplicativo encerrando o teste