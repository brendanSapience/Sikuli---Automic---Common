package com.automic.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SecurityChecks {

	public String EXPDATE="20170310";
	public String CONTACT="Automic Presales US (BSP)";
	
	public SecurityChecks() throws ParseException{
		initiateChecks();
	}
	
	private void initiateChecks() throws ParseException{
		
		Date today = Calendar.getInstance().getTime();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date expDate = df.parse(EXPDATE);
		if(expDate.before(today)){
			System.out.println("This Binary is No Longer Valid...:" + expDate + ":"+today);
			System.out.println("Please contact the author: "+CONTACT);
			System.exit(678);
		}
	}
}