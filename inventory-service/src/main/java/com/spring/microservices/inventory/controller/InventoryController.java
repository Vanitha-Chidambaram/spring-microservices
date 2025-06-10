package com.spring.microservices.inventory.controller;

import com.spring.microservices.inventory.dto.InventoryResponse;
import com.spring.microservices.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryController {

	private final InventoryService inventoryService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
		System.out.println("Received inventory request and checking.."+skuCode);
		log.info("Received inventory request and checking.."+skuCode);
		List<InventoryResponse> inventoryResponses =  inventoryService.isInStock(skuCode);
		log.info("Received inventory .."+inventoryResponses.size() + " --- "+ inventoryResponses);
		return inventoryResponses;
	}
}
