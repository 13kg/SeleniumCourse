package pl.coderslab.seleniumcourse.cucumber.pageobject.zad4;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import pl.coderslab.seleniumcourse.pageobject.MyAccountPage;
import pl.coderslab.seleniumcourse.pageobject.UserData;

import java.time.Month;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/Zad4.feature",
        plugin = {"pretty","html:out"})
public class Zad4Test {

}