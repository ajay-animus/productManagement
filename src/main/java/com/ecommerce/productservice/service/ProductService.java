package com.ecommerce.productservice.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.ecommerce.productservice.entity.ProductEntity;

public interface ProductService {

	void addProducts(List<ProductEntity> products);

	List<ProductEntity> getProducts();

	List<ProductEntity> getProductByName(String productName);

	ProductEntity updateProduct(ObjectId productId, ProductEntity productEntity);

	ProductEntity getProductById(ObjectId productId);

	ObjectId deleteProductById(ObjectId productId);

	List<ProductEntity> getProductsByKeyword(String searchKey);

	List<ProductEntity> getProductsByCategory(String category);

	List<ProductEntity> getProductsByAvailability(Boolean isActiveProduct);

	List<ProductEntity> getProductsInPriceRange(Integer minPrice, Integer maxPrice);

	List<ProductEntity> getSortedProducts(String fieldName, String order);

}
