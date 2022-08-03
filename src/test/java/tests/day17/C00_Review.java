package tests.day17;

public class C00_Review {

    /*
            Actions Class : Mouse ve Keyboard ile yapacagımız bütün eylemlerini gerçekleştirmek için kullandığımız sınıf.
                    Actions actions = new Actions(driver);
                    actions.       .perform(); şeklinde kullanılır. Boş olan yere yapmak istediğimiz eylemin metotu yazılır.

              Mouse Actions :
                     - doubleClick()  : Öğeye çift tıklama yapar.
                     - clickAndHold() : Fareyi serbest bırakmadan uzun tıklama yapar.
                     - dragAndDrop()  : Öğeyi bir noktadan diğerine sürükler ve bırakır.
                     - moveToElement (): Fare işaretçisini öğenin üzerine gider.
                     - contextClick() : Fare üzerinde sağ tıklama yapar.

              Keyboard Actions : Klavyedeki bütün tuşları (Keys Class'ı) kullanmak için Actions class'ından 3 komut kullanırız.
                      - sendKeys() : Öğeye bir dizi anahtar gönderir.
                      - keyDown()  : Klavyede tuşa basma işlemi gerçekleştirir.
                      - keyUp()    : Klavyede tuşu serbest bırakma işlemi gerçekleştirir.

            Actions Class'ını kullanmak için yapılan işlemler :
                1. Actions classından obje olusturmak ve parametre olarak driver vermek
                2. WebElementi locate etmek
                3. Actions classından kullanacagımız metotları kullanmak
                4. En son da .perform(); metotu ile gerçekleştirmek

               !! actions ile baslayan bir kod perform() ile bitmezse calışmaz.
     */

}
