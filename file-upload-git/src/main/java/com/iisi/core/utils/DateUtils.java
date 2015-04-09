package com.iisi.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	public static boolean startDateAfterEndDate(String startDate, String endDate){
		boolean rtnBool = false;
		final Date start = null;
		final Date end = null;
		
		if(start.after(end)){
			rtnBool = true;
		}
		
		return rtnBool;
	}
	
	public static String adToRocDate(Date date){
		String rtnRocDate = "";
		
		if(null != date){
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			int adYyy = cal.get(Calendar.YEAR);
			int mm = cal.get(Calendar.MONTH) + 1;
			int dd = cal.get(Calendar.DATE);			
			int rocYyy = adYyy - 1911;
			
			String rocYyyStr = checkDateLength(String.valueOf(rocYyy), 3);
			String rocMmStr = checkDateLength(String.valueOf(mm), 2);
			String rocDdStr = checkDateLength(String.valueOf(dd), 2);
			
			rtnRocDate = rocYyyStr + rocMmStr + rocDdStr;
			
			return rtnRocDate;
		}else{
			return rtnRocDate;
		}
	}
	
	public static String rocToAdDate(String date){
		String rtnAdDate = "";
		
		String rocYyy = date.substring(0, 3);
		String mm = date.substring(3,5);
		String dd = date.substring(5);
		
		int adYyy = 0;
		
		if(rocYyy.substring(0,1).equals("-")){
			adYyy = 1911 - Integer.parseInt(rocYyy.substring(1));
		}else{
			adYyy = 1911 + Integer.parseInt(rocYyy);
		}
		rtnAdDate = String.valueOf(adYyy) + mm + dd;		
		return rtnAdDate;
	}
	
	private static String checkDateLength(String date, int len){
		String rtnStr = ""; 		
		switch(len){
			case 2:
				if(date.length() != 2){
					rtnStr = "0" + date;
				}else{
					rtnStr = date;
				}
				break;
			case 3:
				if(date.length() == 1){
					rtnStr = "00" + date;
				}else if(date.length() == 2){
					rtnStr = "0" + date;
				}else{
					rtnStr = date;
				}
				break;
			default:
				break;
		}
		
		return rtnStr;
	}
	
	/**
	 * 取得現在時間
	 * @return String
	 */
	public static String getNowTime(){
		String time = "";
		SimpleDateFormat timeFormat = new SimpleDateFormat("hhmmss");
		time = timeFormat.format(new Date());
		return time;
	}
	
	/**
	 * 取得現在日期
	 * @return String
	 */
	public static String getNowDate(){
		return adToRocDate(new Date());
	}
}
