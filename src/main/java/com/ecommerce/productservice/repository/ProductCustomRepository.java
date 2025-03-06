package com.ecommerce.productservice.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ecommerce.productservice.entity.ProductEntity;

public interface ProductCustomRepository extends MongoRepository<ProductEntity, ObjectId> {

	@Query("{'name': {$regex: ?0, $options: 'i'}}")
	Optional<List<ProductEntity>> getProductsByNameSubstring(String substring);
	
	@Query("{'category': {$regex: '^?0$', $options: 'i'}}")
	Optional<List<ProductEntity>> getProductsByCategory(String category);
	
	@Query("{'isActiveProduct': ?0}}")
	Optional<List<ProductEntity>> getProductsByAvailability(Boolean category);

	@Query("{'price' : {$gte: ?0, $lte: ?1}}")
	Optional<List<ProductEntity>> getProductsInPriceRange(Integer minPrice, Integer maxPrice);
}
