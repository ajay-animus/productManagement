package com.ecommerce.productservice.service.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.productservice.constant.CommonConstant;
import com.ecommerce.productservice.constant.ExceptionEnum;
import com.ecommerce.productservice.entity.ProductEntity;
import com.ecommerce.productservice.exceptions.BusinessException;
import com.ecommerce.productservice.repository.ProductCustomRepository;
import com.ecommerce.productservice.repository.ProductRepository;
import com.ecommerce.productservice.service.ProductService;
import com.ecommerce.productservice.utils.ProductUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCustomRepository productCustomRepository;
	
	@Override
	public void addProducts(List<ProductEntity> products) {
		productRepository.saveAll(products);
	}

	@Override
	public List<ProductEntity> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductEntity> getProductByName(String productName) {
		Optional<List<ProductEntity>> optionalProductEntities = productRepository.getProductByName(productName);
		if (optionalProductEntities.isPresent()) {
			return optionalProductEntities.get();
		} else {
			throw new BusinessException(ExceptionEnum.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	@Override
	public ProductEntity updateProduct(ObjectId productId, ProductEntity updatedProductEntity) {
		ProductEntity existingProductEntity = this.getProductById(productId);
		if (Objects.nonNull(existingProductEntity)) {
			log.info("existing product: {}", existingProductEntity.toString());
			ProductUtil.setProductNewValues(existingProductEntity, updatedProductEntity);
			log.info("updated product: {}", existingProductEntity.toString());
			productRepository.save(existingProductEntity);
			return existingProductEntity;
		} else {
			throw new BusinessException(ExceptionEnum.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	@Override
	public ProductEntity getProductById(ObjectId productId) {
		Optional<ProductEntity> optionalProductEntity = productRepository.findById(productId);
		if (optionalProductEntity.isPresent()) {
			return optionalProductEntity.get();
		} else {
			throw new BusinessException(ExceptionEnum.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	@Override
	public ObjectId deleteProductById(ObjectId productId) {
		productRepository.deleteById(productId);
		return productId;
	}

	@Override
	public List<ProductEntity> getProductsByKeyword(String searchKey) {
		Optional<List<ProductEntity>> optionalProducts = productCustomRepository.getProductsByNameSubstring(searchKey);
		if (optionalProducts.isPresent()) {
			return optionalProducts.get();
		} else {
			throw new BusinessException(ExceptionEnum.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	@Override
	public List<ProductEntity> getProductsByCategory(String category) {
		Optional<List<ProductEntity>> optionalProductEntities = productCustomRepository.getProductsByCategory(category);
		if (optionalProductEntities.isPresent()) {
			return optionalProductEntities.get();
		} else {
			throw new BusinessException(ExceptionEnum.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	@Override
	public List<ProductEntity> getProductsByAvailability(Boolean isActiveProduct) {
		Optional<List<ProductEntity>> optionalProductEntities = productCustomRepository.getProductsByAvailability(isActiveProduct);
		if (optionalProductEntities.isPresent()) {
			return optionalProductEntities.get();
		} else {
			throw new BusinessException(ExceptionEnum.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	@Override
	public List<ProductEntity> getProductsInPriceRange(Integer minPrice, Integer maxPrice) {
		Optional<List<ProductEntity>> optionalProductEntities = productCustomRepository.getProductsInPriceRange(minPrice, maxPrice);
		if (optionalProductEntities.isPresent()) {
			return optionalProductEntities.get();
		} else {
			throw new BusinessException(ExceptionEnum.PRODUCT_NOT_FOUND.getMessage());
		}
	}

	@Override
	public List<ProductEntity> getSortedProducts(String fieldName, String order) {
		
		List<ProductEntity> products = getProducts();
		
		if (CommonConstant.ASCENDING_ORDER.equals(order)) {
			if (CommonConstant.ID.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getId().compareTo(product2.getId())).toList();
			} else if (CommonConstant.NAME.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getName().compareTo(product2.getName())).toList();
			} else if (CommonConstant.PRICE.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getPrice().compareTo(product2.getPrice())).toList();
			} else if (CommonConstant.AVAILABLE_QUANTITY.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getAvailableQuantity().compareTo(product2.getAvailableQuantity())).toList();
			}  else if (CommonConstant.CATEGORY.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getCategory().compareTo(product2.getCategory())).toList();
			}  else if (CommonConstant.DESCRIPTION.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getDescription().compareTo(product2.getDescription())).toList();
			} else if (CommonConstant.IS_ACTIVE_PRODUCT.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getIsActiveProduct().compareTo(product2.getIsActiveProduct())).toList();
			}
		} else {
			if (CommonConstant.ID.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getId().compareTo(product2.getId())).toList();
			} else if (CommonConstant.NAME.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getName().compareTo(product2.getName())).toList();
			} else if (CommonConstant.PRICE.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getPrice().compareTo(product2.getPrice())).toList();
			} else if (CommonConstant.AVAILABLE_QUANTITY.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getAvailableQuantity().compareTo(product2.getAvailableQuantity())).toList();
			}  else if (CommonConstant.CATEGORY.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getCategory().compareTo(product2.getCategory())).toList();
			}  else if (CommonConstant.DESCRIPTION.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getDescription().compareTo(product2.getDescription())).toList();
			} else if (CommonConstant.IS_ACTIVE_PRODUCT.equals(fieldName)) {
				return products.stream().sorted((product1, product2) -> product1.getIsActiveProduct().compareTo(product2.getIsActiveProduct())).toList();
			}
		}
		
		return Collections.emptyList();
	}
}
