package com.ecommerce.productservice.repository;


import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.productservice.entity.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity, ObjectId> {

	Optional<List<ProductEntity>> getProductByName(String name);

}
