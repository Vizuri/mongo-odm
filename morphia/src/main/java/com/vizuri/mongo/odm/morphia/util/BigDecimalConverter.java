package com.vizuri.mongo.odm.morphia.util;

import java.math.BigDecimal;

import com.google.code.morphia.converters.SimpleValueConverter;
import com.google.code.morphia.converters.TypeConverter;
import com.google.code.morphia.mapping.MappedField;
import com.google.code.morphia.mapping.MappingException;

public class BigDecimalConverter extends TypeConverter implements SimpleValueConverter {

	public BigDecimalConverter() {
		super(BigDecimal.class);
	}
	
	@Override
	public Object encode(Object value, MappedField optionalExtraInfo) {
		return value == null ? "0" : value.toString();
	}
	
	@Override
	public Object decode(Class targetClass, Object fromDBObject, MappedField optionalExtraInfo) throws MappingException {
		if (fromDBObject == null) return null;
		return new BigDecimal(fromDBObject.toString());
	}

}
