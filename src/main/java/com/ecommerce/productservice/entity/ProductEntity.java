package com.ecommerce.productservice.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.ecommerce.productservice.constant.CollectionConstant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = CollectionConstant.PRODUCTS_COLLECTION)
public class ProductEntity {
	
	@Id
	@JsonSerialize(using = ToStringSerializer.class)
	private ObjectId id;

	private String name;
	
	private String description;
	
	private Integer availableQuantity;
	
	private Integer price;
	
	private Boolean isActiveProduct;
	
	private String category;
	
}
