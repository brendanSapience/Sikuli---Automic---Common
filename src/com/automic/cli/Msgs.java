package com.automic.cli;

public class Msgs {

	private static boolean ShowDebug = true;
	
	public static void showDebug(String s){
		if(ShowDebug){System.out.println("\t %% DEBUG: " + s);}
	}
	
	public static void showInfo(String s){
		System.out.println("\t %% Info: " + s);
	}
	
	public static void showInfoCR(String s){
		System.out.println("\n\t %% Info: " + s);
	}
	
	public static void showError(String s){
		System.out.println("\t -- Error: " + s);
	}
	
	public static void showSuccess(String s){
		System.out.println("\t ++ Success: " + s);
	}
	
	public static void showSuccessCR(String s){
		System.out.println("\n\t ++ Success: " + s);
	}
	
	public static void showButtonFound(){
		System.out.println("\t ++ Element Found!");
	}
	
	public static void setDebug(boolean showDebug){
		ShowDebug = showDebug;
	}
}
