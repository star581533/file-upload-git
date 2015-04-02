package com.iisi.web.test;

public class Test {
	public static void main(String args[]){
		new Test().getOsName();
	}
	
	public void getOsName(){
		String osName = System.getProperty("os.name");
		System.out.println(osName);
	}
}
