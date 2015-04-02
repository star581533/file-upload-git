package com.iisi.api.office;

import java.util.List;

import javax.faces.model.SelectItem;

import com.iisi.api.model.Office;

public interface OfficeService {
	public List<SelectItem> getOfficeItems();
}
