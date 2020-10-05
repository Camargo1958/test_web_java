package org.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;


public class StepDefinitions {

    WebDriver driver = new ChromeDriver();
    private String xPath; // xpath do elemento a ser localizado
    private String elmName; // nome do elemento a ser localizado
    private String elmId; // id do elemento a ser localizado
    private int slcIndx; // Seletor index (busca por valor de opção não funciona)

    @Given("Eu esteja na pagina inmrobo.tk")
    public void eu_esteja_na_pagina_inmrobo_tk() {
        //Define a URL da pagina
        String baseUrl = "http://www.inmrobo.tk";

        // abre o Firefox e direciona para a URL base
        driver.get(baseUrl);

        // maximiza janela
        driver.manage().window().maximize();

        // Seleciona elemento para verificação
        WebElement webElement = driver.findElement(By.className("container-login100"));

        // verifica se elemento está visivel
        assertTrue(webElement.isDisplayed());

    }

    @When("Eu selecionar o link {string}")
    public void eu_selecionar_o_link(String expectedText) {
        // loacaliza o link pelo texto
        WebElement webElement = driver.findElement(By.linkText(expectedText));
        // verifica se esta visivel e seleciona
        boolean isDisplayed = webElement.isDisplayed();
        if(isDisplayed) {
            webElement.click();
        }
        // se o link esta visível o teste foi aprovado
        assertTrue(isDisplayed);
    }

    @Then("O sistema ira para a tela de cadastramento")
    public void o_sistema_ira_para_a_tela_de_cadastramento() {
        // compara as URLs atual e a correta
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "http://www.inmrobo.tk/accounts/signup/";
        // se as URLs forem iguais o teste foi aprovdo
        assertEquals(expectedURL,currentURL);
        // encerra a sessão
        driver.close();
    }

    @Given("Eu esteja na tela de cadastramento")
    public void eu_esteja_na_tela_de_cadastramento() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "http://www.inmrobo.tk/accounts/signup/";
        if(expectedURL!=currentURL) {
            //Define a URL da pagina
            String baseUrl = expectedURL;

            // abre o Firefox e direciona para a URL base
            driver.get(baseUrl);

            // maximiza janela
            driver.manage().window().maximize();
        }

        // obtem a URL atual para verificação
        currentURL = driver.getCurrentUrl();

        // se a URL está correta o passo foi aprovado
        assertEquals(expectedURL, currentURL);
    }

    @When("Eu fornecer o nome do usuario como {string}")
    public void eu_fornecer_o_nome_do_usuario(String userName) {
        // localiza campo para entrada do nome do usuario
        WebElement webElement1 = driver.findElement(By.name("username"));

        // verifica se o campo está visível
        boolean isDisplayed = webElement1.isDisplayed();

        if(isDisplayed) {
            // preenche o texto do campo com o email do usuário
            webElement1.sendKeys(userName);

            // localiza e seleciona campo de senha
            WebElement webElement2 = driver.findElement(By.name("pass"));
            webElement2.click();

        }

        // se o campo está visível passo foi aprovado
        assertTrue(isDisplayed);

    }

    @When("Eu fornecer a senha do usuario como {string}")
    public void eu_fornecer_a_senha_do_usuario(String password) {
        // localiza campo para entrada da senha do usuario
        WebElement webElement1 = driver.findElement(By.name("pass"));

        // verifica se o campo está visível
        boolean isDisplayed = webElement1.isDisplayed();

        if(isDisplayed) {
            // preenche o texto do campo com o email do usuário
            webElement1.sendKeys(password);

            // se a pagina é de cadastramento
            String currentURL = driver.getCurrentUrl();
            String signupURL = "http://www.inmrobo.tk/accounts/signup/";
            if(currentURL==signupURL) {
                // localiza e seleciona campo de confirmação de senha
                WebElement webElement2 = driver.findElement(By.name("confirmpass"));
                boolean isDisplayed2 = webElement1.isDisplayed();
                if (isDisplayed2) webElement2.click();
            }

        }

        // se o campo está visível passo foi aprovado
        assertTrue(isDisplayed);

    }

    @When("Eu confirmar a senha do usuario como {string}")
    public void eu_confirmar_a_senha_do_usuario(String confpass) {
        // localiza campo para entrada da confirmação de senha do usuario
        WebElement webElement1 = driver.findElement(By.name("confirmpass"));

        // verifica se o campo está visível
        boolean isDisplayed = webElement1.isDisplayed();

        if(isDisplayed) {
            // preenche o texto do campo com o email do usuário
            webElement1.sendKeys(confpass);
        }

        // se o campo está visível passo aprovado
        assertTrue(isDisplayed);

    }

    @When("Eu selecionar o botao {string}")
    public void eu_selecionar_o_botao(String btnConf) {
        // localiza o botão para a ser selecionado
        WebElement webElement1 = driver.findElement(By.className("login100-form-btn"));

        // obtem o texto do botao
        String btnText = webElement1.getText();

        // verifica se o botão está visível e contem o texto correto
        boolean isDisplayed = webElement1.isDisplayed();
        boolean txtCorrect = btnText.contains(btnConf);

        if(isDisplayed & txtCorrect) {
            // clica no botão para finalizar a operação
            webElement1.click();
        }

        // se o botão está visível passo foi aprovado
        assertTrue(isDisplayed & txtCorrect);

    }

    @Then("O sistema ira para a tela de Login")
    public void o_sistema_ira_para_a_tela() {
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "http://www.inmrobo.tk/accounts/login/";

        // se a URL está correta o passo foi aprovado
        assertEquals(expectedURL, currentURL);

    }

    @Then("O sistema emitira um alerta de erro no campo de Usuario")
    public void o_sistema_emitira_um_alerta_de_erro_no_campo_de_usuario() {
        // localiza campo para entrada do nome do usuario
        WebElement webElement1 = driver.findElement(By.name("username"));
        // obtem hashcode
        int hashcode1 = webElement1.hashCode();
        // obtem hashcode do elemento ativo
        int hashcode2 = driver.switchTo().activeElement().hashCode();

        // verifica se alerta de erro foi emitido verificando indiretamenteq
        // ue o campo de Usuário não está ativo
        // pois alguns elementos da pagina não possuem id
        assertNotEquals(hashcode1,hashcode2);

    }

    @Then("O sistema permanecera na tela de {string}")
    public void o_sistema_permanecera_na_tela_de(String chkText) {
        String currentURL = driver.getCurrentUrl();
        String expectedURL1 = "http://www.inmrobo.tk/accounts/signup/";
        String expectedURL2 = "http://www.inmrobo.tk/accounts/login/";

        // se a URL está correta o passo foi aprovado
        if(chkText=="Cadastramento") {
            assertEquals(expectedURL1, currentURL);
            driver.close();
        }
        else if (chkText=="Login") {
            assertEquals(expectedURL2, currentURL);
        }

    }

    @Then("O sistema emitira um alerta de erro no campo de Senha")
    public void o_sistema_emitira_um_alerta_de_erro_no_campo_de_senha() {
        // localiza campo para entrada da senha do usuario
        WebElement webElement1 = driver.findElement(By.name("pass"));
        // obtem hashcode
        int hashcode1 = webElement1.hashCode();

        // obtem hashcode do elemento ativo
        int hashcode2 = driver.switchTo().activeElement().hashCode();

        // verifica se alerta de erro foi emitido verificando indiretamenteq
        // ue o campo de Senha não está ativo
        // pois alguns elementos da pagina não possuem id
        assertNotEquals(hashcode1,hashcode2);

    }

    @Then("O sistema emitira a mensagem {string}")
    public void o_sistema_emitira_a_mensagem(String expectedMessage) {
        // localiza campo de mensagem
        WebElement webElement1 = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/span/div"));
        // obtem o texto da mensagem
        String messageText = webElement1.getText();
        // verifica se o texto da mensgem tem o conteúdo esperado
        boolean msgContains = messageText.contains(expectedMessage);
        // se o mensagem está correta o passo foi aprovado
        assertTrue(msgContains);

    }

    @Then("O sistema mostrara a mensagem {string}")
    public void o_sistema_mostrara_a_mensagem(String expectedMessage) {
        String currentURL = driver.getCurrentUrl();
        String expectedURL1 = "http://www.inmrobo.tk/accounts/signup/";
        String expectedURL2 = "http://www.inmrobo.tk/accounts/login/";

        // localiza campo de mensagem
        if(currentURL.contains(expectedURL1))
        {
            this.xPath="/html/body/div/div/div/form/div[1]/span/div";
        }
        else if(currentURL.contains(expectedURL2))
        {
            // xpath: /html/body/div/div[1]/div
            this.xPath="/html/body/div/div[1]/div";
        }

        WebElement webElement1 = driver.findElement(By.xpath(this.xPath));
        // obtem o texto da mensagem
        String messageText = webElement1.getText();
        // verifica se o texto da mensgem tem o conteúdo esperado
        boolean msgContains = messageText.contains(expectedMessage);
        boolean msgDisplayed = webElement1.isDisplayed();
        // se o mensagem está correta o passo foi aprovado
        assertTrue(msgContains && msgDisplayed);

    }

    @Then("O sistema ira para a tela do Cadastro de {string}")
    public void o_sistema_ira_para_a_tela_do_cadastro_de(String expectedTxt) {
        // obtem a URLs atual
        String currentURL = driver.getCurrentUrl();
        // verifica se a URL é a esperada
        boolean containsTxt = currentURL.contains(expectedTxt);
        assertTrue(containsTxt);
    }

    @Given("Eu realize o login com sucesso com as credenciais {string} e {string}")
    public void eu_realize_o_login_com_sucesso_com_as_credenciais_e(String userName, String password) {
        // vai para página inicial
        eu_esteja_na_pagina_inmrobo_tk();
        // entra com o nome do usuário
        eu_fornecer_o_nome_do_usuario(userName);
        // entra com a senha
        eu_fornecer_a_senha_do_usuario(password);
        // confirmar Login
        eu_selecionar_o_botao("Entre");
        // Login completo
        o_sistema_ira_para_a_tela_do_cadastro_de("empregados");
    }

    @Given("O sistema apresentar a tela do Cadastro de {string}")
    public void o_sistema_apresentar_a_tela_do_cadastro_de(String chkTxt) {
        eu_esteja_na_tela_de_cadastramento();
    }

    @When("Eu selecionar o item {string} no menu")
    public void eu_selecionar_o_item_no_menu(String expectedTxt) {
        // localiza o item para a ser selecionado
        this.xPath = "/html/body/nav/div/div/ul/li[2]";
        WebElement webElement1 = driver.findElement(By.xpath(this.xPath));

        // obtem o texto do item
        String itemText = webElement1.getText();

        // verifica se o item está visível e contem o texto correto
        boolean isDisplayed = webElement1.isDisplayed();
        boolean txtCorrect = itemText.contains(expectedTxt);

        if(isDisplayed & txtCorrect) {
            // clica no item para finalizar a operação
            webElement1.click();
        }

        // se o item está visível passo foi aprovado
        assertTrue(isDisplayed & txtCorrect);

    }

    @Then("O sistema apresentara a tela de cadastramento de novo empregado")
    public void o_sistema_apresentara_a_tela_de_cadastramento_de_novo_empregado() {
        // obtem a URLs atual
        String currentURL = driver.getCurrentUrl();
        // verifica se a URL é a esperada
        boolean containsTxt = currentURL.contains("/empregados/new_empregado");
        assertTrue(containsTxt);
    }

    @Given("Eu acesse o cadastramento de novo empregado")
    public void eu_acesse_o_cadastramento_de_novo_empregado() {
        // ir para a página de cadastramento de novo empreagdo
        o_sistema_ira_para_a_tela_do_cadastro_de("empregados");
        // selecionar item do menu
        eu_selecionar_o_item_no_menu("NOVO FUNCIONÁRIO");
        // verificar se a pégina foi carregada
        o_sistema_apresentara_a_tela_de_cadastramento_de_novo_empregado();
    }

    @When("Eu inserir {string} no campo de {string}")
    public void eu_inserir_no_campo_de(String dataTxt, String fldName) {
        // prepara a localização do elemento do campo escolhido
        switch (fldName){
            case "Nome":
                this.elmName="nome";
                break;
            case "CPF":
                this.elmName="cpf";
                break;
            case "Admissão":
                this.elmName="admissao";
                break;
            case "Cargo":
                this.elmName="cargo";
                break;
            case "Salário":
                this.elmName="salario";
                break;
            default:
                System.out.println("Campo indefinido!");
        }
        // seleciona o elemento escolhido
        WebElement webElement1 = driver.findElement(By.name(this.elmName));
        boolean isDisplayed = webElement1.isDisplayed();
        if(isDisplayed) {
            webElement1.click();
            // insere dados
            webElement1.sendKeys(dataTxt);
        }

        // passo aprovado
        assertTrue(isDisplayed);

    }

    @When("Eu selecionar {string} para o {string}")
    public void eu_selecionar_para_o(String option, String fldName) {
        // prepara a localização do elemento do campo escolhido
        if(fldName.contains("Tipo de Contratação")){
            switch (option){
                case "CLT":
                    this.elmId = "clt";
                    break;
                case "PJ":
                    this.elmId = "pj";
                    break;
                default:
                    this.elmId = "-";
                    System.out.println("Opção inválida!");
            }

            // localiza e seleciona o elemento escolhido
            WebElement webElement1 = driver.findElement(By.id(this.elmId));
            boolean isDisplayed = webElement1.isDisplayed();
            if(isDisplayed) {
                webElement1.click();
            }

            // passo aprovado
            assertTrue(isDisplayed);

        }

        if(fldName.contains("Sexo")) {
            // localiza e seleciona a opção escolhida
            switch (option){ // converte em indíde porque por valor não houv localização da opção
                case "Indiferente":
                    this.slcIndx=1;
                    break;
                case "Feminino":
                    this.slcIndx=2;
                    break;
                case "Masculino":
                    this.slcIndx=3;
                    break;
                default:
                    this.slcIndx=0;
            }
            // localiza o elemento de seleção e altera a opção
            WebElement mySelectedElement = driver.findElement(By.name("sexo"));
            Select dropdown = new Select(mySelectedElement);
            dropdown.selectByIndex(this.slcIndx);
            boolean isDisplayed = mySelectedElement.isDisplayed();

            // passo aprovado
            assertTrue(isDisplayed);
        }

    }

    @When("Eu acionar o botao {string}")
    public void eu_acionar_o_botao(String btnTxt) {
        switch (btnTxt) {
            case "Enviar":
                WebElement webElement1 = driver.findElement(By.className("cadastrar-form-btn"));
                boolean isDisplayed = webElement1.isDisplayed();
                webElement1.click();
                assertTrue(isDisplayed);
                break;
            default:
                System.out.println("Botão inválido!");
                assertTrue(false);
        }
    }
        // /html/body/div/div[1]/div
        // /html/body/div/div[1]/div
        //
    @Then("O sistema mostrara uma mensagem de {string} no cadastramento")
    public void o_sistema_mostrara_uma_mensagem_de_sucesso_no_cadastramento(String msgTxt) {
        // localiza o elemento pelo xpath
        this.xPath="/html/body/div/div[1]/div";
        WebElement webElement1 = driver.findElement(By.xpath(this.xPath));
        boolean isDisplayed = webElement1.isDisplayed();
        boolean hasTxt = webElement1.getText().contains(msgTxt);

        // se está visível e contém o texto correto, o passo está OK
        assertTrue(isDisplayed && hasTxt);

    }

}
