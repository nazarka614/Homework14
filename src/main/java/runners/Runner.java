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
        dryRun = false,
        monochrome = true,
        publish = true
)

public class Runner {
    @BeforeClass
    public static void createDriver() {
        System.setProperty("CUCUMBER_PUBLISH_TOKEN", "f91c7df6-5365-4f9a-bca1-23a30d23710a");
        BaseClass.driver = DriverConfig.create(BROWSERS.CHROMEINCOGNITO);

    }

    @AfterClass
    public static void after() {
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        BaseClass.driver.quit();
    }

}
