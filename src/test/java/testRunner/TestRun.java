package testRunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Feature/LO1.feature",
        glue = "stepDefinition",
        plugin = {"pretty", "json:target/cucumber.json"}
)
public class TestRun {
    
    @AfterClass
    public static void generateReport() {
        File reportOutputDirectory = new File("target/cucumber-reports");
        List<String> jsonFiles = new ArrayList<String>();
        jsonFiles.add("target/cucumber.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "My Project");
        configuration.setBuildNumber("1");
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }
}
