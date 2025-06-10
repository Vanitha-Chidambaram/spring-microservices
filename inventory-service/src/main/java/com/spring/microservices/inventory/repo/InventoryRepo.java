package com.spring.microservices.inventory.repo;

import com.spring.microservices.inventory.model.Inventory;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepo extends JpaRepository<Inventory,Long> {
	List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
