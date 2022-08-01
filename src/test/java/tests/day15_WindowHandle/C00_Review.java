package tests.day15_WindowHandle;

public class C00_Review {

    /*
          Alerts
            - Simple Alert : Sadece 'OK' basmaya izin verir. ->  driver.switchTo().alert().accept();
            - Confirm : 2 özellikle 'OK' / 'Cancel' diyebiliriz. -> driver.switchTo().alert().accept() or dismiss();
            - Prompt : Kullanıcıdan bilgi almak ve 'OK' / 'Cancel' tuşlarına basmak için kullanılır.
                       Bir input girişi var, tamam ve iptal etmek için ayrı ayrı 3 fonksiyon.
                       -> driver.switchTo().alert().sendKeys("Dante");
                       -> driver.switchTo().alert().accept();

          iFrame
            - Bir websitesinde calısırken başka bir websitesinden alıntı yapılmasına izin veren tag'ler vardır.
            -> driver.switchTo().frame(WebElement iFrame);  id ve index ile de iframe'e geçiş yapılabilir.
            - iframe'e geçiş yapıldıktan sonra driver'ımız iframe içindedir.
            - iframe'den çıkış yapılmadan driver iframe içinde kalır.
            -> driver.switchTo().defaultContent(); ya da parentFrame(); iframe'den çıkış için syntax.
     */
}