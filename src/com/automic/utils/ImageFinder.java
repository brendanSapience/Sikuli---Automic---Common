package com.automic.utils;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class ImageFinder {

	String RootName = "";
	public boolean ImageFound = false;
	public String ValidFileName = "";
	Screen objScreen;
	String ImageExtension = ".png";
	
	public ImageFinder(String ImageRootName, Screen objScreen, int Wait){
		this.RootName = ImageRootName;
		this.objScreen = objScreen;

		
		if(checkFileName(this.RootName+ImageExtension,Wait)){
			//System.out.println("DEBUG: root file ok: " +this.RootName+ImageExtension );
			ImageFound = true;
			ValidFileName = this.RootName+ImageExtension;
			
			return;
		}else{
			for(int i=0;i<5;i++){
				if(checkFileName(this.RootName+"_seq"+i+ImageExtension,Wait)){
					//System.out.println("DEBUG: non root file ok: " +this.RootName+"_seq"+i+ImageExtension );
					ImageFound = true;
					ValidFileName = this.RootName+"_seq"+i+ImageExtension;
					return;
				}
			}
		}
	}
	
	
	private boolean checkFileName(String FileName, int Wait){
		try {
			Match match = objScreen.find(FileName);
			System.out.println("Score is: "+match.getScore() +" for image: " +FileName);
			objScreen.wait(FileName, Wait);
			
		} catch (FindFailed e2) {
			return false;
		}
		return true;
	}
}
