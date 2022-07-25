package test.day010_2507_TestNG_Giris;

import org.testng.annotations.Test;

public class C01_TestPriority {

    @Test      // TestNG - Testleri alfabetik sıraya göre çalıştırdı.
    public void testAmazon(){
        System.out.println("Amazon Testi");
    }

    @Test
    public void testYoutube(){
        System.out.println("Youtube Testi");
    }

    @Test
    public void testBestBuy(){
        System.out.println("BestBuy Testi");
    }

}
