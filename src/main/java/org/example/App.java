package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Set up Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "/home/fady/IdeaProjects/naga_quiz/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to Nagwa website and select language
        driver.get("https://nagwa.com");
        driver.findElement(By.linkText("English")).click();
        driver.findElement(By.linkText("العربية")).click();

        // Search for lesson
        driver.findElement(By.cssSelector("#search-icon")).click();
        driver.findElement(By.cssSelector("#search-input")).sendKeys("addition");
        driver.findElement(By.cssSelector("#search-button")).click();

        // Click on 2nd result in search results
        driver.findElement(By.cssSelector("#search-results li:nth-child(2) a")).click();

        // Go to worksheet section and click preview button
        driver.findElement(By.cssSelector("#worksheet-section button")).click();

        // Count number of questions on worksheet
        int questionCount = driver.findElements(By.cssSelector("#worksheet-questions li")).size();

        // Print number of questions
        System.out.println("Number of questions: " + questionCount);

        // Close browser
        driver.close();
    }
}
