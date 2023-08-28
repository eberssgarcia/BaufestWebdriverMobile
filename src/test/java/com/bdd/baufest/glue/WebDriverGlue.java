package com.bdd.baufest.glue;

import com.bdd.baufest.step.WebDriverStep;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import mobile.ManageScenario;
import mobile.MobileDriverManager;
import mobile.Util;
import org.junit.Assert;

import static mobile.MobileDriverManager.getDriver;

public class WebDriverGlue {

    AppiumDriver<MobileElement> driver = getDriver();

    private WebDriverStep webDriverStep;
    private Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
        ManageScenario.setScenario(this.scenario);
        webDriverStep = new WebDriverStep();
    }

    @After
    public void afterScenario() {
        if (this.scenario.isFailed()) Util.takeScreenShoot();
        MobileDriverManager.quitDriver();
    }

    // Sign up

    @Given("que me encuentro en la aplicación webdriver")
    public void que_me_encuentro_en_la_aplicación_webdriver() {
        MobileDriverManager.setMobileDriver();
    }

    @When("doy de alta mi usuario {string} {string} {string}")
    public void doy_de_alta_mi_usuario(String email, String password, String repeatPassword) {
        webDriverStep.doyDeAltaMiUsuario(email, password, repeatPassword);
    }

    @Then("validar alerta de usuario registrado")
    public void validarAlertaDeUsuarioRegistrado() {

        String expectedMessage = webDriverStep.getAlertText();
        Assert.assertEquals("You successfully signed up!", expectedMessage);
    }

    // Login

    @When("inicio sesión con mi usuario {string} {string}")
    public void inicioSesiónConMiUsuario(String email, String password) {
        webDriverStep.login(email, password);
    }

    @Then("validar alerta de usuario logeado")
    public void validar_alerta_de_usuario_logeado() {
        String expectedMessage = webDriverStep.getAlertText();
        Assert.assertEquals("You are logged in!", expectedMessage);
    }

    // Form
    @When("completo la sección Form {string} {string}")
    public void completoLaSeccionForm(String input, String criteriaSelect) {
        webDriverStep.enterCriteriaForForm(input, criteriaSelect);
    }

    @And("hago click en el boton Active")
    public void hagoClickEnElBotonActive() {
        webDriverStep.clickToButtonActive();
    }

    @Then("validar alerta de button activo")
    public void validarAlertaDeButtonActivo() {
        String expectedMessage = webDriverStep.getAlertText();
        Assert.assertEquals("This button is active", expectedMessage);
    }

    // Webview
    @And("ingreso a la opcion Webview")
    public void ingresoALaOpcionWebview() {
        webDriverStep.clickToWebview();
    }

    @When("realizo una busqueda de la palabra {string}")
    public void realizoUnaBusquedaDeLaPalabra(String criteria) {
        webDriverStep.clickToSearch(criteria);
    }

    @Then("deberia poder ver los resultados de la busqueda {string}")
    public void deberiaPoderVerLosResultadosDeLaBusqueda(String expectedText) {
        String actualText = webDriverStep.validarResultado();

        // Convertir ambas cadenas a minúsculas antes de comparar
        actualText = actualText.toLowerCase();
        expectedText = expectedText.toLowerCase();

        Assert.assertTrue("Los resultados no contienen la palabra '" + expectedText + "'", actualText.contains(expectedText));
    }


}
