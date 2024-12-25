package com.kksg.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kksg.dtos.StockInfoRequestDTO;
import com.kksg.entity.StockInfo;

public class JsonUtil {

	public static StockInfo convertToObject(String message){
		try {
			
			return new ObjectMapper().readValue(message, StockInfo.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error while converting message to object");	
		}
		
	}

	public static String convertToString(StockInfoRequestDTO request) {
		try {	
			return new ObjectMapper().writeValueAsString(request);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error while converting object to message");
		}
	}

}
