package com.spring.microservices.inventory.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "inventory")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String skuCode;
	private Integer quantity;
}
