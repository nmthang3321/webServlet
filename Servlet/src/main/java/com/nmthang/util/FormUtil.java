package com.nmthang.util;

import java.lang.reflect.InvocationTargetException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class FormUtil {

	@SuppressWarnings("unchecked")
	public static <T> T toModel(Class<T> clazz, HttpServletRequest request) {
		try {
			T model = clazz.newInstance();
			BeanUtils.populate(model, request.getParameterMap());
			return model;

		} catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
			e.printStackTrace();
			return null;
		}
	}
}
