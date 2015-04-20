package com.iisi.web.menu;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

import com.iisi.api.menu.MenuService;

@ManagedBean
@RequestScoped
public class MenuController {
	
	private MenuModel model;
		
	@PostConstruct
	public void init(){
		model = new DefaultMenuModel();
		
		DefaultSubMenu fileMenu = new DefaultSubMenu("檔案處理");
		
		DefaultMenuItem item = new DefaultMenuItem("檔案上傳");
		item.setCommand("#{menuController.fileUpload}");
		item.setIcon("ui-icon-disk");
		item.setAjax(false);
		fileMenu.addElement(item);
		
		item = new DefaultMenuItem("檔案查詢");
		item.setCommand("#{menuController.fileQuery}");
		item.setIcon("ui-icon-search");
		fileMenu.addElement(item);
		
		item = new DefaultMenuItem("檔案刪除");
		item.setCommand("#{menuController.fileDelete}");
		item.setIcon("ui-icon-close");
		fileMenu.addElement(item);
		
		model.addElement(fileMenu);	
		
		DefaultSubMenu accountMenu = new DefaultSubMenu("帳號管理");
		item = new DefaultMenuItem("密碼修改");
		item.setCommand("#{menuController.updatePwd}");
		item.setIcon("ui-icon-arrowrefresh-1-w");
		accountMenu.addElement(item);
		
		item = new DefaultMenuItem("新增使用者");
		item.setCommand("#{menuController.addUser}");
		item.setIcon("ui-icon-disk");
		accountMenu.addElement(item);
		
		item = new DefaultMenuItem("帳號查詢");
		item.setCommand("#{menuController.queryUser}");
		item.setIcon("ui-icon-search");
		accountMenu.addElement(item);
		
		model.addElement(accountMenu);
		
		DefaultSubMenu logQueryMenu = new DefaultSubMenu("紀錄查詢");
		item = new DefaultMenuItem("簽到/簽退紀錄查詢");
		item.setCommand("#{menuController.loginLogQuery}");
		item.setIcon("ui-icon-search");
		logQueryMenu.addElement(item);
		
		item = new DefaultMenuItem("操作紀錄查詢");
		item.setCommand("#{menuController.operationLogQuery}");
		item.setIcon("ui-icon-search");
		logQueryMenu.addElement(item);
		
		model.addElement(logQueryMenu);
	}
	
	public String addUser(){
		return MenuService.ADD_USER;
	}
	
	public String fileDelete(){
		return MenuService.FILE_DELETE;
	}
	
	public String fileQuery(){
		return MenuService.FILE_QUERY;
	}
	
	public String fileUpload(){
		return MenuService.FILE_UP_LOAD;
	}
	
	public String loginLogQuery(){
		return MenuService.LOGIN_LOG_QUERY;
	}
	
	public String operationLogQuery(){
		return MenuService.OPERATION_LOG_QUERY;
	}
	
	public String queryUser(){
		return MenuService.QUERY_USER;
	}
	
	public String updatePwd(){
		return MenuService.UPDATE_PWD;
	}
	
	public String updateUser(){
		return MenuService.UPDATE_USER;
	}
	
	public MenuModel getModel() {
		return model;
	}

	public void setModel(MenuModel model) {
		this.model = model;
	}
}
