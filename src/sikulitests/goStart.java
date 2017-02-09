package sikulitests;

import java.io.PrintStream;
import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class goStart
{
  private static String CHROMELABEL = "chrome";
  private static String FIREFOXLABEL = "firefox";
  private static String IEXPLORERLABEL = "iexplorer";
  
  public static void main(String[] args)
    throws InterruptedException
  {
    try
    {
      App objApp = null;
      
      String BROWSER = "firefox";
      
      if (BROWSER.equalsIgnoreCase(CHROMELABEL))
      {
        ImagePath.setBundlePath("./src/images/chrome");
        
        ImagePath.add("sikulitests.goStart/images/chrome");
        
        objApp = App.open("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
      }
      if (BROWSER.equalsIgnoreCase(FIREFOXLABEL))
      {
        ImagePath.setBundlePath("./src/images/firefox");
        ImagePath.add("sikulitests.goStart/images/firefox");
        
        objApp = App.open("C:/Program Files (x86)/Mozilla Firefox/firefox.exe");
      }
      Thread.sleep(2000L);
      
      Screen objScreen = new Screen();
      
      objScreen.type("searchbar.png", "www.automic.com");
      objScreen.type("\n");
      
      Thread.sleep(1000L);
      try
      {
        Match localMatch = objScreen.wait("marketplace.png", 10.0D);
      }
      catch (FindFailed e)
      {
        throw new Exception("Marketplace icon not found within 10 seconds");
      }
      objScreen.click();
      try
      {
    	  Match localMatch = objScreen.wait("marketplace_login.png", 10.0D);
      }
      catch (FindFailed e)
      {
        throw new Exception("Marketplace login icon not found within 10 seconds");
      }
      objScreen.click();
      
      objScreen.type("marketplace_login_login.png", "brendan.sapience@automic.com");
      objScreen.type("marketplace_login_password.png", "Delta55!");
      objScreen.type("\n");
    }
    catch (Exception e)
    {
      System.out.println(e.toString());
    }
  }
}
