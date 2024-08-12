import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"WEB/stepDef"},
        tags = "@web",
        features = {"src/test/resources/WEB"}
)

public class WebRunner {
}
