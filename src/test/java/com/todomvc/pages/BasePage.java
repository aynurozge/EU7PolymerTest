package com.todomvc.pages;

import com.todomvc.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){//constructor

        PageFactory.initElements(Driver.get(),this);
        //initelements method asking some parameters like Driver
    }

    public WebElement getTab (String str){//WE CREATED THİS METHOD TO CLİCK ON DİFFERENT TABS
        // //div[.='JavaScript']
        String tab = "//div[.='"+str+"']";
        return  Driver.get().findElement(By.xpath(tab));
    }

    public WebElement getLink(String linkName){
        return Driver.get().findElement(By.linkText(linkName));
    }}