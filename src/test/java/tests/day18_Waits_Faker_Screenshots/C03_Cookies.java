package tests.day18_Waits_Faker_Screenshots;

import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void testCookies(){
        // Amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");

        // tum cookie’leri listeleyin
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println("Cookies Miktarı : "+cookies.size());

        int count = 1;
        for(Cookie each : cookies){
            System.out.println((count++)+". Cookie : "+each);
        }

        // Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(cookies.size()>5,"Cookies sayısı 5'den büyük değildir.");

        // ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        // ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        // olusturun ve sayfaya ekleyin
        // eklediginiz cookie’nin sayfaya eklendigini test edin
        // ismi skin olan cookie’yi silin ve silindigini test edin
        // tum cookie’leri silin ve silindigini test edin
    }

}
