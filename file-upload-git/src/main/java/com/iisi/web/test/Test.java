package com.iisi.web.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String args[]){
		new Test().getOsName();
		boolean bool = new Test().verifyBirthYymmdd("");
		System.out.println(bool);
	}
	
	public void getOsName(){
		String osName = System.getProperty("os.name");
		System.out.println(osName);
	}
	
    public static boolean verifyBirthYymmdd(String yyymmdd) {
        boolean bool = false;
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(yyymmdd);
        if (isNum.matches()) {
            bool = true;
        }
        return bool;
    }
}
