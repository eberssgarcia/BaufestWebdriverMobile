package com.bdd.baufest.step;

import com.bdd.baufest.view.WebDriverView;

public class WebDriverStep {
    private WebDriverView webDriverView() {
        return new WebDriverView();
    }

    // Sign Up
    public void doyDeAltaMiUsuario(String email, String password, String repeatPassword) {
        webDriverView().clickToLogin();
        webDriverView().selectToSignUp();
        webDriverView().enterEmailSignUp(email);
        webDriverView().enterPasswordSignUp(password);
        webDriverView().enterRepeatPasswordSignUp(repeatPassword);
        webDriverView().clickToButtonSignUp();
    }

    public String getAlertText() {
        return webDriverView().getAlertText();
    }

    // Login
    public void login(String email, String password) {
        webDriverView().clickToLogin();
        webDriverView().enterEmailSignUp(email);
        webDriverView().enterPasswordSignUp(password);
        webDriverView().clickToButtonLogin();
    }

    // Form
    public void enterCriteriaForForm(String input, String criteriaSelect) {
        webDriverView().clickToForms();
        webDriverView().enterInputField(input);
//        webDriverView().clickToTurnTheSwitchOn();
        webDriverView().clickToSelect();
        webDriverView().selectAnItem(criteriaSelect);
    }

    public void clickToButtonActive() {
        webDriverView().clickToButtonActive();
    }

    // Webview
    public void clickToWebview() {
        webDriverView().clickToWebview();
    }

    public void clickToSearch(String criteria) {
        webDriverView().clickToSearch();
        webDriverView().enterToCriteria(criteria);
    }

    public int getSizeResult(){
        return webDriverView().getSizeResult();
    }
}
