package com.model;

import java.io.Serializable;

public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	private int supplierId;
	private String supplierName;
	private int supplierContactInfo;

	public Supplier(int supplierId, String supplierName, int supplierContactInfo) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.supplierContactInfo = supplierContactInfo;
	}

	public int getSupplierId() {
		return supplierId;

	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public int getSupplierContactInfo() {
		return supplierContactInfo;
	}

	public void setSupplierContactInfo(int supplierContactInfo) {
		this.supplierContactInfo = supplierContactInfo;
	}

	@Override
	public String toString() {
		return "Supplier [supplierId=" + supplierId + ", supplierName=" + supplierName + ", supplierContactInfo="
				+ supplierContactInfo + "]";
	}

}
