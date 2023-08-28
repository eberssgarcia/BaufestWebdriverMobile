package com.bdd.baufest.view;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import mobile.BaseView;
import mobile.MobileDriverManager;
import mobile.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static mobile.MobileDriverManager.getDriver;

public class WebDriverView extends BaseView {

    // Xpath - Sign Up
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Login']")
    private MobileElement optionLogin;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-sign-up-container']")
    private MobileElement optionSignUp;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-email']")
    private MobileElement inputEmail;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-password']")
    private MobileElement inputPassword;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='input-repeat-password']")
    private MobileElement inputRepeatPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-SIGN UP']")
    private MobileElement btnSignUp;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView")
    private AndroidElement alertElement;

    // Xpath - Login
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-LOGIN']")
    private MobileElement btnLogin;

    // Xpath - Forms
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Forms']")
    private MobileElement optionForms;
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='text-input']")
    private MobileElement inputField;
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Dropdown']")
    private MobileElement clickToSelect;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='button-Active']")
    private MobileElement btnActive;

    // Xpath - Webview
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='Webview']")
    private MobileElement optionWebview;
    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Search']")
    private MobileElement btnSearch;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText' and @index='1']")
    private MobileElement inputSearch;

    @AndroidFindBy(xpath = "//*[@class='android.widget.Button' and @text='Toggle navigation bar']")
    private MobileElement btnNavigationBar;
    AppiumDriver<MobileElement> driver = getDriver();

    // General methods
    public void scrollGenerico() {
        Dimension dimension = driver.manage().window().getSize();
        int start_x = (int) (dimension.width * 0.5);
        int start_y = (int) (dimension.height * 0.8);

        int end_x = (int) (dimension.width * 0.2);
        int end_y = (int) (dimension.height * 0.2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(start_x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(end_x, end_y)).release().perform();
    }

    public void waitToElementVisible(WebElement locator) {
        WebDriverWait webDriverWait = new WebDriverWait(getDriver(), 15);
        webDriverWait.until(ExpectedConditions.visibilityOf(locator));
    }

    // Methods - Sign Up
    public void clickToLogin() {
        optionLogin.click();
    }

    public void selectToSignUp() {
        optionSignUp.click();
    }

    public void enterEmailSignUp(String email) {
        inputEmail.sendKeys(email);
    }

    public void enterPasswordSignUp(String password) {
        inputPassword.sendKeys(password);
    }

    public void enterRepeatPasswordSignUp(String repeatPassword) {
        inputRepeatPassword.sendKeys(repeatPassword);
    }

    public void clickToButtonSignUp() {
        btnSignUp.click();
    }

    public String getAlertText() {
        waitToElementVisible(alertElement);
        Util.takeScreenShoot();
        return alertElement.getText();
    }

    // Methods - Login
    public void clickToButtonLogin() {
        btnLogin.click();
    }

    // Forms
    public void clickToForms() {
        optionForms.click();
    }

    public void enterInputField(String input) {
        inputField.sendKeys(input);
    }

    public void clickToSelect() {
        clickToSelect.click();
    }

    public void selectAnItem(String criteriaSelect) {
        List<MobileElement> updatedListOptionSelect = driver.findElements(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView"));

        for (MobileElement option : updatedListOptionSelect) {
            if (option.getText().equals(criteriaSelect)) {
                Util.takeScreenShoot();
                option.click();
                break;
            }
        }
    }

    public void clickToButtonActive() {

        try {
            waitToElementVisible(btnActive);
            Util.takeScreenShoot();
        } catch (Exception e) {
            scrollGenerico(); // Llama al método de Scroll
            waitToElementVisible(btnActive);
        }
        try {
            btnActive.click();
            Util.takeScreenShoot();
        } catch (Exception ex) {
            System.out.println("No se pudo hacer click en el elemento: " + ex.getMessage());
        }
    }

    // Webview
    public void clickToWebview() {
        optionWebview.click();
    }

    public void clickToSearch() {
        waitToElementVisible(btnSearch);
        btnSearch.click();
    }

    public void enterToCriteria(String criteria) {
        try {
            inputSearch.sendKeys(criteria);
            Util.takeScreenShoot();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void enterKeyBoard() {
        ((AndroidDriver) MobileDriverManager.getDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public String validarResultado() {
        MobileElement resultadosElement = driver.findElementByXPath("//*[@class='android.widget.TextView' and @text='The Browser Object']"); // Reemplaza con tu propio XPath
        String resultadosTexto = resultadosElement.getText();
        Util.takeScreenShoot();
        return resultadosTexto;
    }

    public void selectButtonNavigation() {
        waitToElementVisible(btnNavigationBar);
        btnNavigationBar.click();
    }

    public void selectAnTabs(String criteriaSelect) {
        // Convertir el parámetro en minúsculas y aplicar trim()
        criteriaSelect = criteriaSelect.toLowerCase().trim();

        List<MobileElement> updatedListOptionSelect = driver.findElements(By.xpath("//android.view.View[2]/android.view.View[1]/android.widget.ListView/android.view.View"));
        System.out.println("Lista: " + updatedListOptionSelect.size());

        WebDriverWait wait = new WebDriverWait(driver, 10); // Espera hasta 10 segundos

        for (WebElement option : updatedListOptionSelect) {
            System.out.println("Listado: " + option.getText());
            // Convertir el texto del elemento en minúsculas y aplicar trim()
            String optionText = option.getText().toLowerCase().trim();

            if (optionText.contains(criteriaSelect)) {
                Util.takeScreenShoot();

                // Esperar hasta que el elemento sea clickeable
                wait.until(ExpectedConditions.elementToBeClickable(option));

                option.click();
                break;
            }
        }
    }

    public String validateTabs() {
        MobileElement resultadosElement = driver.findElementByXPath("//*[@class='android.widget.Button' and @text='On this page']"); // Reemplaza con tu propio XPath
        String resultadosTexto = resultadosElement.getText();
        Util.takeScreenShoot();
        return resultadosTexto;
    }
}
