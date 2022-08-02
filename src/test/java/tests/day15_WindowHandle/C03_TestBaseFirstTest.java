package tests.day15_WindowHandle;

import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_TestBaseFirstTest extends TestBase {

    @Test
    public void test(){
        driver.get("https:/www.futbin.com/");
        System.out.println("Title : "+driver.getTitle());
    }

}
