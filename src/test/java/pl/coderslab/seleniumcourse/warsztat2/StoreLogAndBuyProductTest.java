package pl.coderslab.seleniumcourse.warsztat2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/cucumber/features/warsztat2.feature",
        plugin = {"pretty","html:out"})
public class StoreLogAndBuyProductTest {
}
