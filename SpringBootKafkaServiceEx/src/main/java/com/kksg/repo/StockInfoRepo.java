package com.kksg.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.kksg.entity.StockInfo;

public interface StockInfoRepo extends JpaRepository<StockInfo, Long>, JpaSpecificationExecutor<StockInfo>  {

	Optional<StockInfo> findByIdAndIsDeletedFalse(Long id);
}
