package Class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        /*
        please do this HW
it is needed to be done before class on saturday
i request everyone to Attempt it as this will help u alot in working with tables and calenders.

1.goto http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login

username=Admin
password=Hum@nhrm123

2. click on PIM option
3. from the table select Any  value of id and click the check box associated with it

make sure that ur code is dynamic i.e
changing the id doesnt effect the logic or xpath
         */


        //tel your project where the webdriver is located
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        // create an instance of WebDriver
        WebDriver driver = new ChromeDriver();
        //Maximize the window
        driver.manage().window().maximize();
        //go to syntax projects.com
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
     WebElement username  =driver.findElement(By.xpath("//input[@id='txtUsername']"));
     username.sendKeys("Admin");
     WebElement password= driver.findElement(By.xpath("//input[@id='txtPassword']"));
     password.sendKeys("Hum@nhrm123");
        driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
        driver.findElement(By.xpath("//b[text()='PIM']")).click();
        List<WebElement> column=driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr/td[2]"));
        for (int i=0;i< column.size();i++){
            String text=column.get(i).getText();
            if (text.equalsIgnoreCase("52384A")){
                System.out.println(i);
                driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr[" + (i+1) + "]/td[1]")).click();
            }
        }


    }
}
