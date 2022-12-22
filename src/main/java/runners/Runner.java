package runners;

import configuretions.BROWSERS;
import configuretions.BaseClass;
import configuretions.DriverConfig;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/feature",//path to feature files
        glue = "steps",//package path
        tags = "@test",//list feature files for run
        dryRun = false
//        monochrome = true,
//        publish = true
)

public class Runner {
    @BeforeClass
    public static void createDriver() {
        //CUCUMBER_PUBLISH_TOKEN=e4eea66f-07d3-47ca-a200-f12148ca38a3
      //  System.setProperty("CUCUMBER_PUBLISH_TOKEN", "e4eea66f-07d3-47ca-a200-f12148ca38a3");
       // BaseClass.driver = DriverConfig.create(BROWSERS.CHROMEINCOGNITO);

    }

    @AfterClass
    public static void after() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BaseClass.driver.quit();
    }

}
