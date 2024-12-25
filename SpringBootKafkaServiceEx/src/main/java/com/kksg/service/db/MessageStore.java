package com.kksg.service.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kksg.entity.StockInfo;
import com.kksg.repo.StockInfoRepo;
import com.kksg.util.JsonUtil;

@Component
public class MessageStore {

	@Autowired
	private StockInfoRepo stockInfoRepo;
	
	public void add(String message) {
		StockInfo si = JsonUtil.convertToObject(message);
		stockInfoRepo.save(si);
	}

}
