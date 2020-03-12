package com.example.app1.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created on Mart, 2020
 *
 * @author selman.kaya
 */
public class ObjectUtils {

	public static String asJsonString(final Object obj) {
		try {
			final String jsonContent = new ObjectMapper().writeValueAsString(obj);
			return jsonContent;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
