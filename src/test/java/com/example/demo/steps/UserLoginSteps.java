package com.example.demo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UserLoginSteps {
    private WebDriver driver = getDriver(); // Serenity WebDriver

    // Test case 1: Positive LogIn test
    @Given("the user opens the login page")
    public void the_user_opens_the_login_page() {
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @When("the user enters the username {string}")
    public void the_user_enters_the_username(String username) {
        findElementById("username", username);
    }

    @When("the user enters the password {string}")
    public void the_user_enters_the_password(String password) {
        findElementById("password", password);
    }

    @When("the user clicks the submit button")
    public void the_user_clicks_the_submit_button() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    @Then("the page URL should contain {string}")
    public void the_page_url_should_contain(String expectedUrlFragment) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.urlContains(expectedUrlFragment));
        assertThat(driver.getCurrentUrl()).contains(expectedUrlFragment);
    }

    @Then("the page should contain the text {string}")
    public void the_page_should_contain_the_text(String expectedText) {
        WebElement pageContent = driver.findElement(By.tagName("body"));
        assertThat(pageContent.getText()).contains(expectedText);
    }

    @Then("the log out button should be displayed")
    public void the_log_out_button_should_be_displayed() {
        WebElement logoutButton = driver.findElement(By.id("logout"));
        assertThat(logoutButton.isDisplayed()).isTrue();
    }

    // Test case 2: Negative username test
    @When("the user enters incorrect username {string}")
    public void the_user_enters_incorrect_username(String username) {
        findElementById("username", username);
    }

    private void findElementById(String username, String username1) {
        WebElement usernameField = driver.findElement(By.id(username));
        usernameField.sendKeys(username1);
    }

    @Then("the error message should be displayed")
    public void the_error_message_should_be_displayed() {
        WebElement errorMessage = driver.findElement(By.id("error"));
        assertThat(errorMessage.isDisplayed()).isTrue();
    }

    @Then("the error message text should be {string}")
    public void the_error_message_text_should_be(String expectedErrorText) {
        WebElement errorMessage = driver.findElement(By.id("error"));
        assertThat(errorMessage.getText()).isEqualTo(expectedErrorText);
    }

    // Test case 3: Negative password test
    @When("the user enters incorrect password {string}")
    public void the_user_enters_incorrect_password(String password) {
        findElementById("password", password);
    }
}
