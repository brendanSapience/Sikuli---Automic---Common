package sikulitests;

import java.io.PrintStream;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Key;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class goStart
{
  private static String CHROMELABEL = "chrome";
  private static String FIREFOXLABEL = "firefox";
  private static String IEXPLORERLABEL = "iexplorer";
  
  private static String IMAGEFOLDER = "images";
  public static void main(String[] args) throws InterruptedException{

    	// the App object represents the instance of the App to open and interact with
      App objApp = null;
      
      String BROWSER = "firefox";
      
      // Handling multiple browsers in one
      if (BROWSER.equalsIgnoreCase(CHROMELABEL)){
        ImagePath.setBundlePath("./src/"+IMAGEFOLDER+"/chrome");
        // the following line is necessary when this code is compiled into a standalone jar. it allows the code to retrieve the images stored in the jar file.
        ImagePath.add("sikulitests.goStart/"+IMAGEFOLDER+"/chrome");
        
        objApp = App.open("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
      }
      if (BROWSER.equalsIgnoreCase(FIREFOXLABEL)){
        ImagePath.setBundlePath("./src/"+IMAGEFOLDER+"/firefox");
        ImagePath.add("sikulitests.goStart/"+IMAGEFOLDER+"/firefox");
        
        // Open the application
        objApp = App.open("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
      }
      
      // Wait a few seconds for the app to load
      Thread.sleep(2000);
      
      Screen objScreen = new Screen();
      
      objScreen.type("searchbar.png", "www.automic.com");
      objScreen.type(Key.ENTER);
      
      Thread.sleep(1000);
      try{
        Match localMatch = objScreen.wait("marketplace.png", 10);
      }
      catch (FindFailed e){
        System.err.println("Marketplace Website did not load in time.");
        System.exit(999);
      }
      objScreen.click();
      try{
    	  Match localMatch = objScreen.wait("marketplace_login.png", 10);
      }
      catch (FindFailed e){
          System.err.println("Marketplace Login did not load in time.");
          System.exit(999);
      }
      objScreen.click();
      
      objScreen.type("marketplace_login_login.png", "brendan.sapience@automic.com");
      objScreen.type("marketplace_login_password.png", "MyPassword123");
      objScreen.type("\n");
    

  }
}
