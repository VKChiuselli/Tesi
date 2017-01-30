package it.clever.spring.tutorial.business.entities;

import org.hibernate.criterion.Property;

public class RestrictionBuilder {

	public Property buildEqRestriction(String propertyName, Object value) {
		
		Property property = Property.forName(propertyName);
		property.eq(value);
		return property;
	}
}
