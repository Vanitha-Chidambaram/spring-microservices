package com.spring.microservices.inventory.util;

import com.spring.microservices.inventory.model.Inventory;
import com.spring.microservices.inventory.repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {
	private final InventoryRepo inventoryRepo;
	@Override
	public void run(String... args) throws Exception {
		Inventory inventory = new Inventory();
		inventory.setSkuCode("EyeShadow");
		inventory.setQuantity(2);
		Inventory inventory1 = new Inventory();
		inventory1.setSkuCode("Sunscreen");
		inventory1.setQuantity(1);
		inventoryRepo.save(inventory);
		inventoryRepo.save(inventory1);
	}
}
