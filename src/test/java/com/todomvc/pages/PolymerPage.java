package com.todomvc.pages;
import com.todomvc.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PolymerPage extends BasePage {

    @FindBy(id = "new-todo")
    public WebElement inputBox;

    @FindBy(id = "edit")
    public WebElement editBox;



    public WebElement createdItemElement(String str){
        return Driver.get().findElement(By.xpath("//label[.='"+str+"']"));
    }}
