package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class LoginStep {
    private WebDriver driver;
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By buttonLoginLocator = By.id("login-button");
    By titleProductsLocator = By.cssSelector("span.title");
    By titleProductsLocator1 = By.cssSelector("span.title");
    By messageError = By.xpath("//h3 [@data-test='error']");

    @Given("El usuario se encuentra en la pantalla de inicio de la pagina")
    public void el_usuario_se_encuentra_en_la_pantalla_de_inicio_de_la_pagina() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @When("El usuario introduce sus credenciales correctamente")
    public void el_usuario_introduce_sus_credenciales_correctamente() {
        driver.findElement(usernameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(buttonLoginLocator).click();
    }
    @Then("El usuario visualiza un mensaje de login exitoso")
    public void el_usuario_visualiza_un_mensaje_de_login_exitoso() {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(titleProductsLocator)));
        assertEquals("PRODUCTS", driver.findElement(titleProductsLocator).getText());
    }

    @When("El usuario introduce sus credenciales incorrectas")
    public void el_usuario_introduce_sus_credenciales_incorrectas() {
        driver.findElement(usernameLocator).sendKeys("standarduser");
        driver.findElement(passwordLocator).sendKeys("sauce");
        driver.findElement(buttonLoginLocator).click();
    }
    @Then("El usuario visualiza un mensaje de login invalido")
    public void el_usuario_visualiza_un_mensaje_de_login_invalido() {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(messageError)));
        assertEquals("Epic sadface: Username and password do not match any user in this service",
                driver.findElement(messageError).getText());
    }

}
