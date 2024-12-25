package com.kksg.service.impl;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.kksg.entity.StockInfo;
import com.kksg.repo.StockInfoRepo;
import com.kksg.service.BaseService;
import com.kksg.service.StockInfoService;

@Service
public class StockInfoServiceImpl extends BaseService<StockInfo, Long> implements StockInfoService {

	public StockInfoServiceImpl(StockInfoRepo stockInfoRepository ) {
        super(stockInfoRepository, stockInfoRepository);
    }
	
	@Override
	protected Specification<StockInfo> prepareFilter() {
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("isDeleted"), false);
	}
	
	
}
