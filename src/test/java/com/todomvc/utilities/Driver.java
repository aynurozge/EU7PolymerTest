package com.todomvc.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

    //we will create s driver object only ıf we don't  already have one
    //we are using encapsulation
    //we are gonna use singleton driver concept you have to your WebDriver object and constructor private

    //so nobody can create an object from this class
    //only way is using getter method
    private Driver(){}
    private static WebDriver driver;

    public static  WebDriver get(){//return type method will return driver object
        if(driver==null){

            String browser = ConfigurationReader.get("browser");//more dynamıc
            switch (browser){
                case"chrome":

                    WebDriverManager.chromedriver().setup();
                    driver =new ChromeDriver();//no parameter constructor
                    break;
                case "chrome-ssl":// for handle the ssl certificate pop-up
                    //ı am gonna provide some chrome options
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.setAcceptInsecureCerts(true);
                    driver = new ChromeDriver(options);
                    break;
                case "chrome-headless"://IT is like a secret browser opening but you are not see it
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "firefox-ssl":// for handle the ssl certificate pop-up//TO ACCEPT INSECURE SERTİFİCATE
                    //ı am gonna provide some chrome options
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions optionsF = new FirefoxOptions();
                    optionsF.setAcceptInsecureCerts(true);
                    driver = new FirefoxDriver(optionsF);
                    break;

                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;

                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;

            }
        }

        return driver;
    }
        public  static void closeDriver(){ // bu metodu kullanmazsak driverım null olmaz ve test case im fail olur
        if(driver != null){
            driver.quit();
            driver = null;
            }
        }

    }

