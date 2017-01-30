package it.clever.spring.tutorial.business.entities;

import java.util.List;

import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

public class QueryFilterItem {

	private String filterPropertyName;
	private Object filterPropertyValue;
	private Criterion restriction;
	private List<Property> propertyList;
	
	public QueryFilterItem() {
	}

	public String getFilterPropertyName() {
		return filterPropertyName;
	}

	public void setFilterPropertyName(String filterPropertyName) {
		this.filterPropertyName = filterPropertyName;
	}

	public Object getFilterPropertyValue() {
		return filterPropertyValue;
	}

	public void setFilterPropertyValue(Object filterPropertyValue) {
		this.filterPropertyValue = filterPropertyValue;
	}

	public Criterion getRestriction() {
		return restriction;
	}

	public void setRestriction(Criterion restriction) {
		this.restriction = restriction;
	}

	public List<Property> getPropertyList() {
		return propertyList;
	}

	public void setPropertyList(List<Property> propertyList) {
		this.propertyList = propertyList;
	}
	
	
}
