package com.sathya.model;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;
@javax.persistence.Entity
public class Category {
	@Id
	int categoryId;
	@Column
	String categoryName;
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDiscription() {
		return categoryDiscription;
	}
	public void setCategoryDiscription(String categoryDiscription) {
		this.categoryDiscription = categoryDiscription;
	}
	@Column
	String categoryDiscription;
	
	
	
}
