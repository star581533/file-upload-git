package com.iisi.core.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
	
	private static int adYyy;
	private static int mm;
	private static int dd;
	private static int rocYyy;
	
	
	public static boolean startDateAfterEndDate(String startDate, String endDate){
		boolean rtnBool = false;
		final Date start = null;
		final Date end = null;
		
		if(start.after(end)){
			rtnBool = true;
		}
		
		return rtnBool;
	}
	
	/**
	 * 西元日期轉民國日期
	 * @param date
	 * @return
	 */
	public static String adToRocDate(Date date){
		String rtnRocDate = "";
		
		if(null != date){			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			adYyy = cal.get(Calendar.YEAR);
			mm = cal.get(Calendar.MONTH) + 1;
			dd = cal.get(Calendar.DATE);			
			rocYyy = adYyy - 1911;
			
			String rocYyyStr = checkDateLength(String.valueOf(rocYyy), 3);
			String rocMmStr = checkDateLength(String.valueOf(mm), 2);
			String rocDdStr = checkDateLength(String.valueOf(dd), 2);
			
			rtnRocDate = rocYyyStr + rocMmStr + rocDdStr;
			
			return rtnRocDate;
		}else{
			return rtnRocDate;
		}
	}
	
	/**
	 * 民國日期轉西元日期
	 * @param date
	 * @return
	 */
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
	
	/**
	 * 判斷日期長度是否要加0
	 * @param date
	 * @param len
	 * @return
	 */
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
	 * 取得現在時間(時:分：秒)
	 * @return String
	 */
	public static String getNowTime(){
		return getNowTime("HHmmss");
	}
	
	/**
	 * 取得現在時間(時：分：秒：微秒)
	 * @return String
	 */
	public static String getNowTimeAndMicroSec(){
		return getNowTime("HHmmssSSS");
	}
	
	/**
	 * 取得所填入之日期格式
	 * @param format String
	 * @return String
	 */
	private static String getNowTime(String format){
		String time = "";
		//時間格式
		SimpleDateFormat timeFormat = new SimpleDateFormat(format);
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
	
	/**
	 * 取得現在民國年
	 * @return
	 */
	public static String getNowYear(){
		Calendar cal = Calendar.getInstance();
		adYyy = cal.get(Calendar.YEAR);
		rocYyy = adYyy - 1911;		
		String rocYyyStr = checkDateLength(String.valueOf(rocYyy), 3);
		return rocYyyStr;
	}
}
