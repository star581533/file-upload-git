package com.iisi.api.constant;

public class ConstantMethod {

	/**
	 * 判斷來源資料是否為空
	 * @param source 來源資料
	 * @return boolean
	 */
	public static boolean verifyColumn(String source){
		boolean bool = false;
		if(source == null || source.length() == 0){
			bool = true;
		}
		return bool;
	}
	
	/**
	 * 比對兩個欄位資料是否相同
	 * @param one 欄位1
	 * @param two 欄位2
	 * @return boolean
	 */
	public static boolean compareTwoColumn(String one, String two){
		boolean bool = false;
		//判斷資料是否為空
		if(verifyColumn(one)){
			return false;
		}
		//判斷資料是否為空
		if(verifyColumn(two)){
			return false;
		}
		//比對資料
		if(one.equals(two)){
			bool = true;
		}
		
		return bool;
	}
}
