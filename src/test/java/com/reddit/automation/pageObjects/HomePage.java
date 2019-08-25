package com.reddit.automation.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage{

    @FindBy(xpath="//button/span/h1[text()='Home']")
    WebElement textHome;

    private WebDriver driver =null;
    MySubRedditsPage mySubRedditsPage = null;

    public HomePage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public boolean isHomePageOpened(){

        boolean focusOnHomePage = false;

        if(textHome.isDisplayed()){

            focusOnHomePage = true;

        }

        return focusOnHomePage;

    }

    public MySubRedditsPage openRedditMySubbreddits() throws Exception{

        Thread.sleep(5000);

        driver.get(driver.getCurrentUrl() + "/subreddits/mine");
        mySubRedditsPage = new MySubRedditsPage(driver);

        Thread.sleep(5000);

        return mySubRedditsPage;
    }


}
