package tests.day012_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class C01_SoftAssert {

    @Test
    public void test(){
        int a = 10;
        int b = 20;
        int c = 30;

        // - HardAssert kullandığımızda ilk test fail olursa devamındaki kodlar çalışmaz.
        //      Assert.assertTrue(a>b);
        //      Assert.assertTrue(a<c);
        //      Assert.assertTrue(b>a);

        SoftAssert softAssert = new SoftAssert(); // - SoftAssert kullandıgımızda ise fail olan test sonrasındaki kodlar/testler çalışmaya devam eder.
            softAssert.assertTrue(a>b,"1.Test FAILED"); // FAILED
            softAssert.assertTrue(a>c,"2.Test FAILED"); // FAILED
            softAssert.assertTrue(b>a,"3.Test FAILED"); // PASSED
            softAssert.assertTrue(c>a,"4.Test FAILED"); // PASSED
            softAssert.assertTrue(c<a,"5.Test FAILED"); // FAILED

            softAssert.assertAll();  // SoftAssert objesi create edildiğinde assertAll() metotu her zaman en alta yazılır!
    }
}