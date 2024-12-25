package com.kksg.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StockInfoRequestDTO {
	private String stockCode;
	private Double stockCost;
	
}
