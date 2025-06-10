package com.spring.microservices.inventory.service;

import com.spring.microservices.inventory.dto.InventoryResponse;
import com.spring.microservices.inventory.repo.InventoryRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class InventoryService {
	@Autowired
	private InventoryRepo inventoryRepo;

	@Transactional
	public List<InventoryResponse> isInStock(List<String> skuCode){
		log.info("Checking inventory"+skuCode.size());
		return inventoryRepo.findBySkuCodeIn(skuCode)
				.stream()
				.map(inventory -> InventoryResponse.builder()
						.skyCode(inventory.getSkuCode())
						.isInStock(inventory.getQuantity()>0)
				.build()).toList();
	}
}
