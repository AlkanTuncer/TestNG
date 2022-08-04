package tests.day17_ActionsAndFiles;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExist {

    // Selenium ile windows uygulamalarını test edemiyoruz. Ama JAVA kullanabiliriz.
    // PC'de bir dosya olup olmadıgını kontrol etmek için JAVA kullanabilriz.
    // System.getProperty("user.home") -> PC'deki user klasörünü verir.

    @Test
    public void testFilePath(){  // Masaüstüne 'Deneme1' isimli klasör olusturup içine 'appium' isimli excel dosyası olusturduk.

        System.out.println("user.home : "+System.getProperty("user.home")); // C:\Users\alkan
        System.out.println("user.dir : "+System.getProperty("user.dir"));   // C:\Users\alkan\IdeaProjects\TestNG

        // C:\Users\alkan\Desktop\Deneme1\appium\selenium -> Dosyamızın yolu
        String path = System.getProperty("user.home")+"\\Desktop\\Deneme1\\selenium.xlsx";
        String filePath = "C:\\Users\\alkan\\Desktop\\Deneme1\\selenium.xlsx";

        System.out.println(path);
        System.out.println(filePath);

        System.out.println("Files.exists(Paths.get(filePath)) = " + Files.exists(Paths.get(filePath)));

        // pom.xml dosyamızın pathi : C:\Users\alkan\IdeaProjects\TestNG\pom.xml
        String pathPomXml = System.getProperty("user.dir")+"\\pom.xml";
        System.out.println("pom.xml Path : "+pathPomXml);

        Assert.assertTrue(Files.exists(Paths.get(pathPomXml)),"pom.xml dosyası mevcut değildir.");

    }
}