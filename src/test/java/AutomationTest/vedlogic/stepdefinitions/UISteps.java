package AutomationTest.vedlogic.stepdefinitions;

import AutomationTest.vedlogic.base.DriverManager;
import AutomationTest.vedlogic.config.ConfigReader;
import AutomationTest.vedlogic.pages.CartPage;
import AutomationTest.vedlogic.pages.CheckoutPage;
import AutomationTest.vedlogic.pages.LoginPage;
import AutomationTest.vedlogic.pages.ProductsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UISteps {
    private final LoginPage loginPage = new LoginPage(DriverManager.getDriver());
    private final ProductsPage productsPage = new ProductsPage(DriverManager.getDriver());
    private final CartPage cartPage = new CartPage(DriverManager.getDriver());
    private final CheckoutPage checkoutPage = new CheckoutPage(DriverManager.getDriver());

    @Given("the user opens the SauceDemo login page")
    public void theUserOpensTheSauceDemoLoginPage() {
        loginPage.open();
    }

    @When("the user logs in with valid credentials")
    public void theUserLogsInWithValidCredentials() {
        loginPage.loginAs(ConfigReader.get("username"), ConfigReader.get("password"));
    }

    @Then("the products page should be displayed")
    public void theProductsPageShouldBeDisplayed() {
        Assert.assertEquals(productsPage.getTitle(), "Products", "Match the Products page title");
    }

    @And("the user adds a backpack to the cart")
    public void theUserAddsABackpackToTheCart() {
        productsPage.addBackpackToCart();
    }

    @And("the user opens the cart")
    public void theUserOpensTheCart() {
        productsPage.openCart();
    }

    @Then("the cart should contain the backpack")
    public void theCartShouldContainTheBackpack() {
        Assert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
    }

    @When("the user completes checkout")
    public void theUserCompletesCheckout() {
        cartPage.clickCheckout();
        checkoutPage.fillInformation("Ved", "Logic", "390001");
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
    }

    @Then("the order should be completed successfully")
    public void theOrderShouldBeCompletedSuccessfully() {
        Assert.assertEquals(checkoutPage.getSuccessMessage(), "Thank you for your order!");
    }

    @When("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String username, String password) {
        loginPage.loginAs(username, password);
    }

    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"));
    }
}
