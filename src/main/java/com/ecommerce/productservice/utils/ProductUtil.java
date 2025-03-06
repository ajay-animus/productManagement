package com.ecommerce.productservice.utils;

import java.util.Objects;

import com.ecommerce.productservice.entity.ProductEntity;

public class ProductUtil {
	
	private ProductUtil () {
		throw new IllegalStateException("Util class not be instantiated");
	}
	
	public static void setProductNewValues(ProductEntity oldEntity, ProductEntity newEntity) {
		if (Objects.nonNull(newEntity.getName())) {
			oldEntity.setName(newEntity.getName());
		}
		if (Objects.nonNull(newEntity.getDescription())) {
		oldEntity.setDescription(newEntity.getDescription());
		}
		if (Objects.nonNull(newEntity.getCategory())) {
		oldEntity.setCategory(newEntity.getCategory());
		}
		if (Objects.nonNull(newEntity.getAvailableQuantity())) {
		oldEntity.setAvailableQuantity(newEntity.getAvailableQuantity());
		}
		if (Objects.nonNull(newEntity.getIsActiveProduct())) {
		oldEntity.setIsActiveProduct(newEntity.getIsActiveProduct());
		}
		if (Objects.nonNull(newEntity.getPrice())) {
		oldEntity.setPrice(newEntity.getPrice());
		}
	}

}
