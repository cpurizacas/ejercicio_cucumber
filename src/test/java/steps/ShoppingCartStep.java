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

import static org.junit.Assert.*;

public class ShoppingCartStep {
    private WebDriver driver;
    By usernameLocator = By.id("user-name");
    By passwordLocator = By.id("password");
    By buttonLoginLocator = By.id("login-button");
    By titleProductsLocator = By.cssSelector("span.title");
    By buttonAddToCartLocator = By.id("add-to-cart-sauce-labs-backpack");
    By buttonRemoveToCartLocator = By.id("remove-sauce-labs-backpack");
    By statusCartLocator = By.cssSelector("span.shopping_cart_badge");

    @Given("El usuario se encuentra en la pantalla de productos")
    public void el_usuario_se_encuentra_en_la_pantalla_de_productos() {
        System.setProperty("webdriver.chrome.driver", "./src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        driver.findElement(usernameLocator).sendKeys("standard_user");
        driver.findElement(passwordLocator).sendKeys("secret_sauce");
        driver.findElement(buttonLoginLocator).click();

        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(titleProductsLocator)));
        assertEquals("PRODUCTS", driver.findElement(titleProductsLocator).getText());
    }
    @When("El usuario agrega un producto a su carrito de compras con el boton ADD TO CART")
    public void el_usuario_agrega_un_producto_a_su_carrito_de_compras_con_el_boton_add_to_cart() {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.elementToBeClickable(driver.findElement(buttonAddToCartLocator)));

        driver.findElement(buttonAddToCartLocator).click();
    }
    @Then("El usuario visualiza el icono carrito de compras con un producto cargado")
    public void el_usuario_visualiza_el_icono_carrito_de_compras_con_un_producto_cargado() {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.visibilityOf(driver.findElement(statusCartLocator)));

        assertEquals("1", driver.findElement(statusCartLocator).getText());
    }

    @Then("El usuario quita un producto de su carrito de compras con el boton REMOVE")
    public void el_usuario_quita_un_producto_de_su_carrito_de_compras_con_el_boton_remove() {
        WebDriverWait ewait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ewait.until(ExpectedConditions.elementToBeClickable(driver.findElement(buttonRemoveToCartLocator)));

        driver.findElement(buttonRemoveToCartLocator).click();
    }
}
