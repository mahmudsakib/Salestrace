package salestrace;



import java.util.ArrayList;
import java.util.List;




import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AutomationTest {
   
    private String baseUrl = "https://salestrace.netlify.app";
    
    public static RemoteWebDriver driver = null;
    
    
 


    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
    	System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        
        
  }
    
   
    

    //LogIn Successfully
    @Test(priority = 1)   
    public void LoginTest() throws InterruptedException {

    	
    	
        // Enter valid username and password
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='username']"));
        searchBox.sendKeys("Tanvir");

        WebElement searchBox1 = driver.findElement(By.xpath("//input[@id='password']"));
        searchBox1.sendKeys("1234567");

        driver.findElement(By.xpath("//button[@id='login']")).click();
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//img[@alt='Ellipse_3']")).click(); 
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//button[normalize-space()='Sign out']")).click();
        Thread.sleep(2000);
    }
    
    
    //Home
    @Test(priority = 2)   
    public void home() throws InterruptedException {
    	
    // Enter valid username and password
    WebElement searchBox = driver.findElement(By.xpath("//input[@id='username']"));
    searchBox.sendKeys("Tanvir");

    WebElement searchBox1 = driver.findElement(By.xpath("//input[@id='password']"));
    searchBox1.sendKeys("1234567");

    driver.findElement(By.xpath("//button[@id='login']")).click();
    Thread.sleep(2000);
        
      }
    
    
    //Summary
    @Test(priority = 3)   
    public void summary() throws InterruptedException {
         
    	
    	
    	  driver.findElement(By.xpath("//img[@alt='rightArrow']")).click();
    	   Thread.sleep(2000);
    	   driver.findElement(By.xpath("//p[normalize-space()='Sales Tracing']")).click(); 
    	

      driver.findElement(By.xpath("//div[contains(text(),'Summary')]")).click();
      Thread.sleep(6000);

      
      driver.findElement(By.xpath("//select[@class='selectInput w-48']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[2]/select[1]/option[4]")).click();
    //  Filter the month
      driver.findElement(By.xpath("(//option[@value='[object Object]'])[3]")).click();
      Thread.sleep(2000);
      
      
      
      //Search Button
      driver.findElement(By.xpath("//button[@class='searchButton']")).click();
      Thread.sleep(4000);
     
   // Find the table element.
      WebElement table = driver.findElement(By.xpath("//div[@class='ag-body ag-layout-normal']")); 

   // Get the number of rows in the table.
      List<WebElement> rows = table.findElements(By.tagName("tr"));

      // Specify the desired row index (zero-based index).
      int desiredRowIndex = 2; 

      // Check if the desired row index is valid.
      if (desiredRowIndex >= 0 && desiredRowIndex < rows.size()) {
          WebElement desiredRow = rows.get(desiredRowIndex);
          List<WebElement> cells = desiredRow.findElements(By.tagName("td"));

          // List to store the elements in the desired row.
          List<String> elementsInDesiredRow = new ArrayList<>();

          for (WebElement cell : cells) {
              String elementText = cell.getText();
              elementsInDesiredRow.add(elementText);
          }

       
         
          for (int columnIndex = 0; columnIndex < elementsInDesiredRow.size(); columnIndex++) {
              String element = elementsInDesiredRow.get(columnIndex);
              System.out.println("Column: " + columnIndex + ", Value: " + element);
          }
      } else {
          System.out.println("Filter the month properly.");
      }
    }



      
      
      
 /*     // Get the number of rows in the table.
      List<WebElement> rows = table.findElements(By.tagName("tr"));

     // List to store the randomly selected elements.
      final List<String> randomlySelectedElements = new ArrayList<>();

       //Select one element randomly per row and add it to the list.
      for (WebElement row : rows) {
     	    List<WebElement> cells = row.findElements(By.tagName("td"));
     	    if (!cells.isEmpty()) {
     	        int randomIndex = new Random().nextInt(cells.size());
     	        String randomElementText = cells.get(randomIndex).getText();
     	        randomlySelectedElements.add(randomElementText);
     	    }
     	}
     //  Print the cell.
      System.out.println("Is filter work properly:");
      for (String element : randomlySelectedElements) {
          System.out.println(element);
      }

      // Compare all the row and coll and check if they are the same or different.
      boolean allElementsSame = randomlySelectedElements.stream()
              .allMatch(e -> e.equals(randomlySelectedElements.get(0)));

      if (allElementsSame) {
          System.out.println("Filter the month correcly.");
      } else {
          System.out.println("Filter can not work.");
      }*/
        

    
    //Status
  @Test(priority = 4)   
  public void status() throws InterruptedException {
       
  	
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
    Thread.sleep(2000);
    
    //Status
    driver.findElement(By.xpath("//div[contains(text(),'status')]")).click();
    Thread.sleep(2000);
    
    
    driver.findElement(By.xpath("(//select[@class='selectInput w-48']")).click();
    
    //Filter the month
    driver.findElement(By.xpath("(//option[@value='[object Object]'])[6]")).click();
    Thread.sleep(2000);
    
    
    //Search Button
    driver.findElement(By.xpath("//button[@class='searchButton']")).click();
    Thread.sleep(2000);
    
  }
  
  
  //Exception
    //Expired Contract All
  @Test(priority = 5)   
  public void expiredcontractall() throws InterruptedException {
       
  	
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
    Thread.sleep(2000);
   
    driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//a[@href='/expiredContractAll']")).click();
    Thread.sleep(2000);
    
    driver.findElement(By.xpath("//select[1]")).click();
    
    //Filter the History
    driver.findElement(By.xpath("//option[@value='History']")).click();
    Thread.sleep(2000);
    
    
    
    //Submit Button
    driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
    Thread.sleep(3000);
    
  }
  
  
//Exception
  //Expired Contract Authorized
    
@Test(priority = 6)   
public void expiredcontractauthorized() throws InterruptedException {
     
	
    
    driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
  Thread.sleep(2000);
  
  //driver.navigate().back();
 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
  Thread.sleep(2000);
  
  driver.findElement(By.xpath("//a[@href='/expiredContractAuthorised']")).click();
  Thread.sleep(2000);
  
  driver.findElement(By.xpath("//body/div[@id='app']/div/div[@class='flex flex-col h-screen overflow-y-scroll']/main/div[@class='flex bg-black dark:bg-slate-800 drop-shadow-sm']/div[@class='bg-borderColor w-full dark:bg-slate-700']/div/div[@class='headingDiv']/div[@class='flex gap-3 justify-end pt-2']/select[1]")).click();
  
  //Filter the History
  driver.findElement(By.xpath("//option[@value='History']")).click();
 
  Thread.sleep(2000);
  
  
  //Submit Button
  driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
  Thread.sleep(3000);
  
}
    
    
    

//Exception
//Product Not In Correct All
@Test(priority = 7)   
public void Productnotincorrectall() throws InterruptedException {
 
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='/productNotInContractAll']")).click();
Thread.sleep(2000);


//Filter the History
driver.findElement(By.xpath("//option[@value='History']")).click();

Thread.sleep(2000);


//Submit Button
driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
Thread.sleep(3000);

}



//Exception
//Product Not In Correct Authorized
@Test(priority = 8)   
public void ProductNotInCorrectAuthorized() throws InterruptedException {
 
	driver.get("https://salestrace.netlify.app/login");

driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='/productNotInContractAuthorised']")).click();
Thread.sleep(2000);


//Filter the History
driver.findElement(By.xpath("//option[@value='History']")).click();

Thread.sleep(2000);


//Submit Button
driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
Thread.sleep(3000);

}



//Exception
//Unknown Contract All
@Test(priority = 9)   
public void UnknownContractAll() throws InterruptedException {

	driver.get("https://salestrace.netlify.app/login");

driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='/unknownContractAll']")).click();
Thread.sleep(2000);


//Filter the History
driver.findElement(By.xpath("//option[@value='History']")).click();

Thread.sleep(2000);


//Submit Button
driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
Thread.sleep(3000);

}



//Exception
//unknownContractAuthorised
@Test(priority = 10)   
public void unknownContractAuthorised() throws InterruptedException {

	driver.get("https://salestrace.netlify.app/login");

driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='/unknownContractAuthorised']")).click();
Thread.sleep(3000);


//Filter the History
driver.findElement(By.xpath("//option[@value='History']")).click();

Thread.sleep(2000);


//Submit Button
driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
Thread.sleep(3000);

}




//Exception
//invalidPrice
@Test(priority = 11)   
public void invalidPrice() throws InterruptedException {

	driver.get("https://salestrace.netlify.app/login");

driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='/invalidPrice']")).click();
Thread.sleep(2000);

//Filter the month
driver.findElement(By.xpath("(//option[@value='[object Object]'])[5]")).click();
Thread.sleep(2000);



//Search Button
driver.findElement(By.xpath("//button[@class='searchButton']")).click();
Thread.sleep(4000);

}
    
    
    
    
  //Exception
  //unknownProduct
  @Test(priority = 12)   
  public void unknownProduct() throws InterruptedException {
  
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  Thread.sleep(2000);
  driver.findElement(By.xpath("//div[@class='flex justify-start items-center gap-x-1 cursor-pointer'][normalize-space()='Exception']")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/unknownProduct']")).click();
  Thread.sleep(3000);
  
  
  //Filter the History
  driver.findElement(By.xpath("//option[@value='History']")).click();
  
  Thread.sleep(2000);
  
  
  //Submit Button
  driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
  Thread.sleep(3000);
  
  }

  
  
//Tracing File Repository
  @Test(priority = 13)   
  public void Tracing() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Tracing File Repository')]")).click();
    Thread.sleep(2000);
   
    
    
    //Filter the month
    driver.findElement(By.xpath("(//option[@value='[object Object]'])[4]")).click();
    Thread.sleep(2000);
    
    
    //Search Button
    driver.findElement(By.xpath("//button[@class='searchButton']")).click();
    Thread.sleep(2000);
    
  }
    
    
 //work not done
//Exception Rules
  @Test(priority = 14)   
  public void Exceptionrule() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[1]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Exception Rules')]")).click();
    Thread.sleep(2000);
    
    
    driver.findElement(By.xpath("//button[@type='Buton']")).click();
    Thread.sleep(2000);
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//option[@value='60652']"));
    driver.findElement(By.xpath("//option[@value='12580']"));
   
   Thread.sleep(2000);
   
   
   Thread.sleep(2000);
    driver.findElement(By.xpath("//label[normalize-space()='Applies To']"));
 
  Thread.sleep(2000);
    
    
    
    //Search Button
    driver.findElement(By.xpath("//button[@class='searchButton']")).click();
   Thread.sleep(2000);
    
  }
    
    
  //MasterData
  //Dashboard
    
    @Test(priority = 15)   
    public void Dashboard() throws InterruptedException {
         
    	driver.get("https://salestrace.netlify.app/login");
        
        driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
      Thread.sleep(2000);
      driver.findElement(By.xpath("//ul[2]//li[1]")).click(); 
      Thread.sleep(2000);
      
      
     
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]")).click();
      Thread.sleep(2000);
     
    }
    
    
    
  //MasterData  
 //EndUsers
  @Test(priority =16)   
  public void EndUsers() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[2]//li[1]")).click(); 
    Thread.sleep(2000);
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'End User')]")).click();
    Thread.sleep(2000);
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@href='/manageAttributes']")).click();
    Thread.sleep(2000);
    
   
   
   
    
  }
  
  
  
  //MasterData  
  //ManageHieracy
   @Test(priority =17)   
   public void ManageHieracy() throws InterruptedException {
        
   	driver.get("https://salestrace.netlify.app/login");
       
       driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
     Thread.sleep(2000);
     driver.findElement(By.xpath("//ul[2]//li[1]")).click(); 
     Thread.sleep(2000);
     
     Thread.sleep(2000);
     driver.findElement(By.xpath("//div[contains(text(),'End User')]")).click();
     Thread.sleep(2000);
    
     Thread.sleep(2000);
     driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/ul[2]/ul[2]/ul[2]/li[1]/a[1]")).click();
     Thread.sleep(2000);
     
   }
   
   
   
 //MasterData  
   //tracingDataMapingManage
    @Test(priority =18)   
    public void tracingDataMapingManage() throws InterruptedException {
         
    	driver.get("https://salestrace.netlify.app/login");
        
        driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
      Thread.sleep(2000);
      driver.findElement(By.xpath("//ul[2]//li[1]")).click(); 
      Thread.sleep(2000);
      
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[contains(text(),'End User')]")).click();
      Thread.sleep(2000);
     
      Thread.sleep(2000);
      driver.findElement(By.xpath("//a[@href='/tracingDataMapingManage']")).click();
      Thread.sleep(2000);
      
    }
  
    
  //MasterData  
    //tracingDataMapingManage
     @Test(priority =19)   
     public void tracingDataMapingManag() throws InterruptedException {
          
     	driver.get("https://salestrace.netlify.app/login");
         
         driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
       Thread.sleep(2000);
       driver.findElement(By.xpath("//ul[2]//li[1]")).click(); 
       Thread.sleep(2000);
       
       Thread.sleep(2000);
       driver.findElement(By.xpath("//div[contains(text(),'End User')]")).click();
       Thread.sleep(2000);
      
       Thread.sleep(2000);
       driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/ul[2]/ul[2]/ul[4]/li[1]/a[1]")).click();
       Thread.sleep(2000);
       
     }
  
    
    
    //MasterData  
//Product
  @Test(priority =20 )   
  public void Product() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[2]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Product')]")).click();
    Thread.sleep(2000);
   
    
    
  
    
  }
  
 
    
    //MasterData 
//Distributor
  @Test(priority =21 )   
  public void Distributor() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[2]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Distributor')]")).click();
    Thread.sleep(2000);
   
    
    
  
    
  }
    
    
    //Report
  //Dashboard
  @Test(priority =22 )   
  public void Dashboard1() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Dashboard')]")).click();
    Thread.sleep(2000);
   
    
    
  
    
  }
  
  
  //Report
//SalesTracingTrend
    //By Invoice Data
  @Test(priority =23 )   
  public void SalesTracingTrend() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Sales Tracing Trend')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@href='/reportByInvoceDate']")).click();
   
   }
  
 
  //Report
//By Repoting Data
  @Test(priority =24 )   
  public void ByRepotingData() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Sales Tracing Trend')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@href='/reportByReportingDate']")).click();
   
    
    
  
    
  }
  
  
 
  //Report
//By Production
  @Test(priority =25 )   
  public void ByProduction() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Sales Tracing Trend')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@href='/reportByProduct']")).click();
   
    
    
  
    
  }
  
  
  //Report  
//By End Users
  @Test(priority =26 )   
  public void ByEndUsers() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Sales Tracing Trend')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@href='/reportByEndUser']")).click();
   
    
    
  
    
  }
  
  
    //not Done
  //Report
// End Users
  @Test(priority =27 )   
  public void EndUsers1() throws InterruptedException {
       
  	driver.get("https://salestrace.netlify.app/login");
      
      driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
    Thread.sleep(2000);
    driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
    Thread.sleep(2000);
    
    
   
    Thread.sleep(2000);
    driver.findElement(By.xpath("//div[contains(text(),'Enduser')]")).click();
    
    Thread.sleep(2000);
    driver.findElement(By.xpath("//a[@class='tooltip text-left fill-testGrey hover:fill-white hover:bg-testPurple px-5 py-2 my-2 flex items-center gap-x-2 rounded-md text-")).click();
   
    
    
  
    
  }
  
  
  //Report
  //Special Pricing
//productDetailReport
 @Test(priority =28 )   
 public void productDetailReport() throws InterruptedException {
      
 	driver.get("https://salestrace.netlify.app/login");
     
     driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
   Thread.sleep(2000);
   driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
   Thread.sleep(2000);
   
   
  
   Thread.sleep(2000);
   driver.findElement(By.xpath("//div[contains(text(),'Special Pricing')]")).click();
   
   Thread.sleep(2000);
   driver.findElement(By.xpath("//a[@href='/productDetailReport']")).click();
  
   }
 
 
//Report
 //Special Pricing
//contractDetailReport
@Test(priority =29 )   
public void contractDetailReport() throws InterruptedException {
     
	driver.get("https://salestrace.netlify.app/login");
    
    driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//div[contains(text(),'Special Pricing')]")).click();
  
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/contractDetailReport']")).click();
 
  }


//Report
//Special Pricing
//pendingContract
@Test(priority =30 )   
public void pendingContract() throws InterruptedException {
   
	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("//div[contains(text(),'Special Pricing')]")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='/pendingContract']")).click();

}
 



//Report
//Special Pricing
//expiryReport
@Test(priority =31 )   
public void expiryReport() throws InterruptedException {
 
	driver.get("https://salestrace.netlify.app/login");

driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("//div[contains(text(),'Special Pricing')]")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("//a[@href='/expiryReport']")).click();

}




//Report

//Gross To Net
@Test(priority =32 )   
public void expiryReport1() throws InterruptedException {

	driver.get("https://salestrace.netlify.app/login");

driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
Thread.sleep(2000);
driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
Thread.sleep(2000);



Thread.sleep(2000);
driver.findElement(By.xpath("")).click();

Thread.sleep(2000);
driver.findElement(By.xpath("")).click();

}
    
    
    
  //Report
  //Usage Report
  @Test(priority =33 )   
  public void UsageReport() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  Thread.sleep(2000);
  driver.findElement(By.xpath("//div[contains(text(),'Usage Report')]")).click();
  
  
  
  }
    
    
//Report
  //Pricing Expiring Contracts
  @Test(priority =34 )   
  public void PricingExpiringContracts() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[3]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  Thread.sleep(2000);
  driver.findElement(By.xpath("//div[contains(text(),'Pricing Expiring Contracts')]")).click();
  Thread.sleep(2000);
  
  
  
  } 
  
  
  
//Price Management
  //View Pricing Details
  @Test(priority =35 )   
  public void ViewPricingDetails() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  Thread.sleep(2000);
  driver.findElement(By.xpath("//div[contains(text(),'View Pricing Details')]")).click();
  Thread.sleep(2000);
  
  
  
  }
  
  
  
//Price Management
  //Enduser Contract
  //home
  @Test(priority =36 )   
  public void EnduserContracthome() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Contract')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/ul[4]/ul[2]/ul[1]/li[1]/a[1]")).click();
  Thread.sleep(2000);
  
  
  }
  
  
  
//Price Management
  //Enduser Contract
  //FindContractView
  @Test(priority =37 )   
  public void FindContractView() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Contract')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/FindContractView']")).click();
  Thread.sleep(2000);
  
  
  }
    
  
//Price Management
  //Enduser Contract
  //initiateContract
  @Test(priority =38 )   
  public void initiateContract() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Contract')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[3]//li[1]//a[1]")).click();
  Thread.sleep(2000);
  
  
  }
    
    
  
//Price Management
  //Enduser Contract
  //manageRole
  @Test(priority =39 )   
  public void manageRole() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Contract')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/manageRole']")).click();
  Thread.sleep(2000);
  
  
  }
  
  
//Price Management
  //Enduser Contract
  //Sendnotification
  @Test(priority =40 )   
  public void Sendnotification() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Contract')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/main[1]/div[1]/div[1]/div[1]/ul[4]/ul[2]/ul[5]/li[1]/a[1]")).click();
  Thread.sleep(2000);
  
  
  }
  
  
  
//Price Management
  //Enduser Contract
  //notificationHistory
  @Test(priority =41 )   
  public void notificationHistory() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Contract')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/notificationHistory']")).click();
  Thread.sleep(2000);
  
  
  }
  
  
  
//Price Management
  //Enduser Contract
  //contractDetailReport
  @Test(priority =42 )   
  public void contractDetailReport1() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Contract')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/contractDetailReport']")).click();
  Thread.sleep(2000);
  
  
  }
  
  
//Price Management
  //Enduser Eligibility
  //priceActivationHistory
  @Test(priority =43 )   
  public void priceActivationHistory() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Eligibility')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/priceActivationHistory']")).click();
  Thread.sleep(2000);
  
  
  }
  
  
  
//Price Management
  //Enduser Eligibility
  //eligibilityCompliance
  @Test(priority =44 )   
  public void eligibilityCompliance() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Eligibility')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/eligibilityCompliance']")).click();
  Thread.sleep(2000);
  
  
  }
  
  
  
//Price Management
  //Enduser Eligibility
  //enduserProfile
  @Test(priority =45 )   
  public void enduserProfile() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Enduser Eligibility')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/enduserProfile']")).click();
  Thread.sleep(2000);
  
  
  }
  
  
  
//Price Management
  //Trading Partner Agreement
  //viewProgram
  @Test(priority =46 )   
  public void viewProgram() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Trading Partner Agreement')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/viewProgram']")).click();
  Thread.sleep(2000);
  
  
  }
 
  
  
//Price Management
  //Trading Partner Agreement
  //addnew
  @Test(priority =47 )   
  public void addnew() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Trading Partner Agreement')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[2]//li[1]//a[1]")).click();
  Thread.sleep(2000);
  
  
  }
  
  
  

//Price Management
  //Gpo member
  //gpoMemberMatch
  @Test(priority =48 )   
  public void gpoMemberMatch() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Gpo member')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/gpoMemberMatch']")).click();
  Thread.sleep(2000);
  
  
  }

  

//Price Management
  //Gpo member
  //gpoMemberRepository
  @Test(priority =49 )   
  public void gpoMemberRepository() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Gpo member')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/gpoMemberRepository']")).click();
  Thread.sleep(2000);
  
  
  }
  
  
//Price Management
  //Charge Back
  //rebateSummary
  @Test(priority =50 )   
  public void rebateSummary() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Charge Back')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/rebateSummary']")).click();
  Thread.sleep(2000);
  
  
  }
    
  
//Price Management
  //Charge Back
  //rebateVarienceDetailReport
  @Test(priority =51 )   
  public void rebateVarienceDetailReport() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(2000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Charge Back')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/rebateVarienceDetailReport']")).click();
  Thread.sleep(4000);
  
  
  }
  
  
//Price Management
  //Charge Back
  //rebateExclusion
  @Test(priority =52 )   
  public void rebateExclusion() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[4]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Charge Back')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/rebateExclusion']")).click();
  Thread.sleep(4000);
  
  
  }
    
  
//Admin
  //Setting
  @Test(priority =53 )   
  public void Setting() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Setting')]")).click();
  Thread.sleep(2000);
 
  
  
  }
    
  
//Admin
  //Dataload&Process
  @Test(priority =54 )   
  public void Dataload() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Data load & Process')]")).click();
  Thread.sleep(2000);
 
  
  
  }
  
  
//Admin
  //EDI Data Validate
  @Test(priority =55 )   
  public void EDIDataValidate() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'EDI Data Validate')]")).click();
  Thread.sleep(2000);
 
  
  
  }
  
  
//Admin
  //Non EDI Data Load Detais
  @Test(priority =56 )   
  public void NonEDIDataLoadDetais() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Non EDI Data Load Detais')]")).click();
  Thread.sleep(2000);
 
  
  
  }
  
  
//Admin
  //User
  //userManagement
  @Test(priority =57 )   
  public void userManagement() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'User')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/userManagement']")).click();
  Thread.sleep(2000);
 
  
  
  }
  
//Admin
  //User
  //roleManagement
  @Test(priority =58 )   
  public void roleManagement() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'User')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/roleManagement']")).click();
  Thread.sleep(2000);
 
  
  
  }
  
  
//Admin
  //Income Data Details
  //NonEDIDataLoadDetails
  @Test(priority =59 )   
  public void NonEDIDataLoadDetails() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Income Data Details')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/NonEDIDataLoadDetails']")).click();
  Thread.sleep(2000);
 
  
  
  }
  
//Admin
  //Income Data Details
  //GPOMemberRoster
  @Test(priority =60 )   
  public void GPOMemberRoster() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Income Data Details')]")).click();
  Thread.sleep(2000);
  driver.findElement(By.xpath("//a[@href='/GPOMemberRoster']")).click();
  Thread.sleep(2000);
 
  
  
  }
  
  
//Admin
 
  //Meta Data Management
  @Test(priority =61 )   
  public void MetaDataManagement() throws InterruptedException {
   
  	driver.get("https://salestrace.netlify.app/login");
  
  driver.findElement(By.xpath("//li[@class='p-3 flex items-center justify-center rounded-md hover:fill-white hover:bg-testPurple']")).click(); 
  Thread.sleep(2000);
  driver.findElement(By.xpath("//ul[5]//li[1]")).click(); 
  Thread.sleep(4000);
  
  
  
  
  driver.findElement(By.xpath("//div[contains(text(),'Meta Data Management')]")).click();
  Thread.sleep(2000);
  
 
  
  
  }
  
  
    
    
    @AfterClass
    public void tearDown() throws InterruptedException {
    	Thread.sleep(3000);
        driver.quit();
    }
}
    
