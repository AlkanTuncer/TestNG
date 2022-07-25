package tests.day010_2507_TestNG_Giris;

import org.testng.annotations.Test;

public class C01_Priority1 {

    @Test (priority = 53)    // Testler verdiğimiz priority sırasına göre çalışır. (Öncelik az olanda) Eksi '-' değer verirsek ilk o çalışır hata almayız.
    public void testAmazon(){
        System.out.println("Amazon Testi");
    }

    @Test (priority = 17)
    public void testYoutube(){
        System.out.println("Youtube Testi");
    }

    @Test (priority = 'A')   // A'nın ASCII değeri : 065
    public void testBestBuy(){
        System.out.println("BestBuy Testi");
    }

}
