package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App 
{
    public static void main( String[] args )
    {
        // Set up Selenium WebDriver
        System.setProperty("webdriver.chrome.driver", "/home/fady/IdeaProjects/naga_quiz/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Navigate to Nagwa website and select language
        driver.get("https://nagwa.com");

        // Select language
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/ul/li[1]/a/span")).click();
        driver.findElement(By.xpath("/html/body/header/div[1]/div/div[2]/ul/li[1]/ul/li[1]/a")).click();

        // Search for lesson
        driver.findElement(By.cssSelector("body > header > div.top-header > div > div.search > button")).click();
        driver.findElement(By.id("txt_search_query")).sendKeys("addition");
        driver.findElement(By.xpath("//*[@id=\"btn_global_search\"]/i")).click();

        // Click on 2nd result in search results
        driver.findElement(By.xpath("/html/body/div/div[1]/div/div/main/div[3]/ul/li[2]/div/a")).click();

        //Scroll down till the bottom of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Go to worksheet section and click preview button
        driver.findElement(By.xpath("//*[@id=\"WorksheetSection\"]/div/div[2]/div/a")).click();

        // Count number of questions on worksheet
        int questionCount = driver.findElements(By.xpath("/html/body/div/div[1]/div/div/main/div[2]/div")).size();

        // Print number of questions
        System.out.println("Number of questions: " + questionCount);


        // Close browser
        driver.close();
    }
}
