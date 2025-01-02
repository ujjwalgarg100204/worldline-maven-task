package com.ujjwalgarg.automation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class LoginAutomationTest {

  @Test
  void testPositiveLogin() {
    // Set up the WebDriver
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

    // Configure ChromeOptions for headless mode
    WebDriver driver = getWebDriver();

    try {
      // Open the login page
      driver.get("https://practicetestautomation.com/practice-test-login/");

      // Locate username, password fields, and the submit button
      WebElement usernameField = driver.findElement(By.id("username"));
      WebElement passwordField = driver.findElement(By.id("password"));
      WebElement submitButton = driver.findElement(By.id("submit"));

      // Perform login with valid credentials
      usernameField.sendKeys("student");
      passwordField.sendKeys("Password123");
      submitButton.click();

      // Verify the URL of the new page
      String currentUrl = driver.getCurrentUrl();
      assertTrue(currentUrl.contains("practicetestautomation.com/logged-in-successfully/"),
          "URL does not contain expected path.");

      // Verify text on the new page
      WebElement bodyText = driver.findElement(By.tagName("body"));
      String pageText = bodyText.getText();
      assertTrue(pageText.contains("Congratulations") || pageText.contains("successfully logged in"),
          "Page does not contain expected text.");

      // Verify the "Log out" button is displayed
      WebElement logoutButton = driver.findElement(By.xpath("//a[contains(text(), 'Log out')]"));
      assertTrue(logoutButton.isDisplayed(), "Log out button is not displayed.");

    } finally {
      // Close the browser
      driver.quit();
    }
  }

  private WebDriver getWebDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless"); // Runs Chrome in headless mode
    options.addArguments("--disable-gpu"); // Disables GPU rendering
    options.addArguments("--window-size=1920,1080"); // Sets the window size for rendering
    options.addArguments("--disable-extensions"); // Disables extensions
    options.addArguments("--no-sandbox"); // Bypass OS security model
    options.addArguments("--disable-dev-shm-usage"); // Avoids issues with shared memory

    // Initialize WebDriver with ChromeOptions
    return new ChromeDriver(options);
  }
}
