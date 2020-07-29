package com.nmthang.util;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil <T>{
	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}

	public T toModel(Class<T> clazz) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			return (T) objectMapper.readValue(this.value, clazz);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder result = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new HttpUtil(result.toString());
	}
}
