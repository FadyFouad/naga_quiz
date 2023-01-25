### Q1: Given that you were asked to test a mobile application;

when opening the application, the latest
3 books are displayed instantly, and the user can explore the application either as an anonymous
user or as a registered user. The registered user has full permission to download any number of
books, unlike, the anonymous user who cannot download more than 5 books then a warning
message will be raised informing the user to register to download more books.

     answe   
     answe   
     answe   

### Q2: In a SQL database there are three tables, Users, Books, and Reading History.

1. Write a SQL query to return (User name, Book name, and Reading date) to show the history of books read by the users

---

```sql
SELECT Users.name, Books.title, Reading_History.reading_date
FROM Users
         JOIN Reading_History ON Users.id = Reading_History.user_id
         JOIN Books ON Reading_History.book_id = Books.id;
```

2. Write a SQL query to return (User name, number of read books) to list the users who read
   more than one book.

---

```sql
SELECT Users.user_name, COUNT(Reading_History.book_id) as 'number of read books'
FROM Users
         INNER JOIN Reading_History ON Users.student_id = Reading_History.student_id
GROUP BY Users.user_name
HAVING COUNT(Reading_History.book_id) > 1;
```

---

### Q3: As an educator on the nagwa website, you can add your own question from “Add Question” page.

     answe   

### Q4: Count Questions in Worksheet Automation Task [Bonus]

    An automation task is needed to simulate the search for a lesson on nagwa website then opening
    the lesson worksheet to count the number of questions in this worksheet.

---

This is a Java program that uses the Selenium WebDriver library to automate the process of

1. navigating to the Nagwa website.
2. selecting a language.
3. searching for a lesson.
4. clicking on the second search result.
5. scrolling to the bottom of the page.
6. going to the worksheet section, and clicking the preview button.
7. The program also counts the number of questions on the worksheet and prints the count to the console.

---

```java
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    public static void main(String[] args) {
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

        // Scroll down till the bottom of the page
        // This code uses JavaScript to scroll to the bottom of the page.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Go to worksheet section and click preview button
        driver.findElement(By.xpath("//*[@id=\"WorksheetSection\"]/div/div[2]/div/a")).click();

        // Count number of questions on worksheet
        int questionCount = driver.findElements(By.xpath("/html/body/div/div[1]/div/div/main/div[2]/div")).size();

        // Print number of questions to the console.
        System.out.println("Number of questions: " + questionCount);

        // Close browser
        driver.close();
    }
}
```