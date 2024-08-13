import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"API/stepDef"},
        tags = "@api",
        features = {"src/test/resources/API"}
)

public class APIRunner {
}