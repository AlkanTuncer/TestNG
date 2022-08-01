package tests.day15_WindowHandle;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBase extends TestBase {

    @Test
    public void test(){
        driver.get("https:/www.futbin.com/");
    }

}
