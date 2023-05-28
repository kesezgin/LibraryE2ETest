package com.library.step_definitions;

import com.library.utils.DBUtils;
import com.library.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static io.restassured.RestAssured.baseURI;

public class Hooks {

    @Before("@db")
    public void connection(){
        DBUtils.createConnection();
    }

    @After("@db")
    public void destroy(){
        DBUtils.destroyConnection();
    }

    @After("@ui")
    public void teardown(Scenario scenario){

        if(scenario.isFailed()){
            byte[] ss = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(ss,"image/png",scenario.getName());
        }

        Driver.closeDriver();
    }

    @Before("@api")
    public void baseURL(){
        baseURI = "http://library1.cydeo.com/rest/v1";
    }

}
