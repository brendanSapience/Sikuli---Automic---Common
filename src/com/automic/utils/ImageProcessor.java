package com.automic.utils;

import java.io.File;
import java.util.ArrayList;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Location;
import org.sikuli.script.Screen;

import com.automic.cli.Msgs;

public class ImageProcessor {

	  private float ACCEPTABLEMATCH;
	  private Location DEFAULTLOCATION;
	  private File[] ALLIMAGEFILES;
	  private String IMAGEFOLDER;
	  
	public ImageProcessor(String BundleImagePath,float DefaultAcceptableMatch, Location DefaultOffset){
		this.ACCEPTABLEMATCH = DefaultAcceptableMatch;
		this.DEFAULTLOCATION = DefaultOffset;
		this.IMAGEFOLDER = BundleImagePath;
		File f = new File(BundleImagePath);
		this.ALLIMAGEFILES = f.listFiles();
	}
	
	 public String processImageWithMatch(String ImageName, Screen screen, int Wait, float ExpectedMatch){ 
		  return processImageWithOffsetAndMatch(ImageName, screen,Wait,ExpectedMatch,DEFAULTLOCATION);
	  }
	  
	 public String processImageWithOffset(String ImageName, Screen screen, int Wait,Location location){ 
		  return processImageWithOffsetAndMatch(ImageName, screen,Wait,ACCEPTABLEMATCH,location);
	  }
	  
	 public String processImage(String ImageName, Screen screen, int Wait){ 
		  return processImageWithOffsetAndMatch(ImageName, screen,Wait,ACCEPTABLEMATCH,DEFAULTLOCATION);
	  }
	  
	 public String processImageWithOffsetAndMatch(String ImageName, Screen screen, int Wait,float ExpectedMatch,Location location){
		  ImageFinder finder = new ImageFinder(this.ALLIMAGEFILES,ImageName,screen,Wait,ExpectedMatch,location);
			if(finder.ImageFound){
				try {
					org.sikuli.script.Pattern pat = new org.sikuli.script.Pattern(finder.ValidFileName).similar(ExpectedMatch).targetOffset(location);
					screen.wait(pat, Wait);
				} catch (FindFailed e) {
					return null;
				}
				return finder.ValidFileName;
			}else{
				System.out.println(" \t -- Error: Could not find a match for: " + ImageName);
				return null;
			}
	  }
}
