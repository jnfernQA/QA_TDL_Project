package com.qa.main.utils;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import static org.springframework.beans.BeanUtils.copyProperties;

public class SpringBeanUtil {
	
	public static void mergNotNull(Object source, Object target) {
		copyProperties(source,target,getNullPropName(source));
	}
	
	private static String[] getNullPropName(Object src) {
		final BeanWrapper wrappedSrObj = new BeanWrapperImpl(src);
		
		Set<String> propName = new HashSet<>();
		for (PropertyDescriptor descriptor : wrappedSrObj.getPropertyDescriptors()) {
			if(wrappedSrObj.getPropertyValue(descriptor.getName()) == null) 
				propName.add(descriptor.getName());
		}
		
		return propName.toArray(new String[propName.size()]);
	}

}
