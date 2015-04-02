package com.iisi.web.header;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;

import org.springframework.stereotype.Controller;

@Controller
@SessionScoped
public class HeaderController {

	private String userName;
	
	@PostConstruct
	public void init(){
		System.out.println("-------------------------HeaderController");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}	
}
