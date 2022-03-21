package com.test.demowebdrivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebDriverManagerChromeSetUp {
    public static void main(String[] args) {
        //Create instance of ChromeOptions Class
        ChromeOptions handlingSSL = new ChromeOptions();

        //Using the 'accept insecure cert method' with true as parameter to accept the untrusted certificate
        handlingSSL.setAcceptInsecureCerts(true);

        //Creating instance of Chrome driver by passing reference of ChromeOptions object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver(handlingSSL);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.selenium.dev/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
