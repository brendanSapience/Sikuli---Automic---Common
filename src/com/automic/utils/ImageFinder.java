package com.automic.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import com.automic.cli.Msgs;

public class ImageFinder {

	//String RootName = "";
	public boolean ImageFound = false;
	public String ValidFileName = "";
	Screen objScreen;
	String ImageExtension = ".png";
	String ImageSeqLabel = "_seq";
	
	public ImageFinder(File[] AllImageFiles, String imageName, Screen objScreen, int Wait,float ExpectedMatch, Location location){

		this.objScreen = objScreen;

		ArrayList<File> filesFound = getMatchingFiles(AllImageFiles,imageName);
			
		Msgs.showInfo("Matching Files Found: " + filesFound.size());
		for(File file : filesFound){
			if(checkFileName(file.getName(),Wait,ExpectedMatch,location)){
				ImageFound = true;
				ValidFileName = file.getName();
				return;
			}
		}
	}
	
	private boolean checkFileName(String FileName, int Wait,float ExpectedMatch, Location location){
		Match match = null;
		try {
//			try {
//				Thread.sleep(4000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			objScreen.setAutoWaitTimeout(Wait);
			org.sikuli.script.Pattern pat = new org.sikuli.script.Pattern(FileName).similar(ExpectedMatch).targetOffset(location);
			
			match = objScreen.find(pat);
			
			Msgs.showInfo("Score is: "+match.getScore() +" for image: " +FileName);
			objScreen.wait(pat, Wait);
			
		} catch (FindFailed e2) {
			Msgs.showInfo("Fail - Score is: "+match.getScore() +" for image: " +FileName);
			return false;
		}
		return true;
	}
	
	private ArrayList<File> getMatchingFiles(File[] Files, String Pattern){
		ArrayList<File> ValidFiles = new ArrayList<File>();
		for(File f : Files){

			Msgs.showDebug("Considering file: " + f.getName() + " with pattern: " + Pattern);
			if(f.getName().equals(Pattern+ImageExtension) || f.getName().startsWith(Pattern+ImageSeqLabel)){
				ValidFiles.add(f);
			}
		}
		return ValidFiles;
	}
}
