package com.iisi.web.testUser;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import org.springframework.stereotype.Controller;

@Controller
@SessionScoped
public class UserController {
	private String name;
	
	private String email;
	
	private String officeId;
	
	private List<SelectItem> items;
	
	public String registerAction(){
		return "result";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOfficeId() {
		return officeId;
	}

	public void setOfficeId(String officeId) {
		this.officeId = officeId;
	}

	public List<SelectItem> getItems() {
		items = new ArrayList<SelectItem>();
		items.add(new SelectItem("1", "一科"));
		items.add(new SelectItem("2", "二科"));
		return items;
	}

	public void setItems(List<SelectItem> items) {
		this.items = items;
	}
	
	
}
