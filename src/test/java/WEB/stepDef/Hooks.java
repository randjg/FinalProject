package WEB.stepDef;

import io.cucumber.java.*;

public class Hooks extends BaseTest{

    @Before
    public void beforeTest(){
        getDriver();
    }

    @After
    public void afterTest(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
