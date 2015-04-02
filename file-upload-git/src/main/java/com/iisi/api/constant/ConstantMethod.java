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
}
