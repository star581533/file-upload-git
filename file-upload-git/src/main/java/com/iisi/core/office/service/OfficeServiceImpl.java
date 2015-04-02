package com.iisi.core.office.service;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.iisi.api.db.DBFactory;
import com.iisi.api.model.Office;
import com.iisi.api.office.OfficeService;

@Service("officeService")
public class OfficeServiceImpl implements OfficeService {

	@Inject
	private DBFactory dbFactory;

	private List<Office> getOffice() {
		StringBuilder sql = new StringBuilder();
		sql.append("select * from office");
		List<Office> list = (List<Office>)dbFactory.query(new ArrayList<String>(),
				sql.toString(), Office.class);
		return list;
	}

	@Override
	public List<SelectItem> getOfficeItems() {
		List<SelectItem> items = new ArrayList<SelectItem>();
		List<Office> offices = this.getOffice();
		
		for(Office office : offices){
			SelectItem item = new SelectItem();
			items.add(new SelectItem(office.getOfficeId(), office.getOfficeName()));
		}
		
		return items;
	}

}
