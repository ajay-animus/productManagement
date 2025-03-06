package com.ecommerce.productservice.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.productservice.constant.ApiURLConstant;
import com.ecommerce.productservice.constant.CommonConstant;
import com.ecommerce.productservice.entity.ProductEntity;
import com.ecommerce.productservice.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;

@Validated
@RestController
@RequestMapping(ApiURLConstant.PRODUCTS_CONTROLLER)
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping(ApiURLConstant.ADD_PRODUCT)
	@Operation(summary = "add new product")
	public ResponseEntity<String> addProducts(@RequestBody List<ProductEntity> products) {
		productService.addProducts(products);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(CommonConstant.PRODUCT_ADD_SUCCESS.concat(": ").concat(products.toString()));
	}

	@GetMapping(ApiURLConstant.GET_PRODUCTS)
	@Operation(summary = "get all products")
	public List<ProductEntity> getAllProducts() {
		return productService.getProducts();
	}

	@GetMapping(ApiURLConstant.GET_PRODUCT_BY_NAME)
	@Operation(summary = "get product by name")
	public List<ProductEntity> getProductName(@PathVariable("productName") String productName) {
		return productService.getProductByName(productName);
	}

	@GetMapping(ApiURLConstant.GET_PRODUCT_BY_ID)
	@Operation(summary = "get product by id")
	public ProductEntity getProductById(@PathVariable("productId") ObjectId productId) {
		return productService.getProductById(productId);
	}

	@PatchMapping(ApiURLConstant.UPDATE_PRODUCT)
	@Operation(summary = "update product")
	public ProductEntity updateProduct(@PathVariable("productId") ObjectId productId,
			@RequestBody ProductEntity productEntity) {
		return productService.updateProduct(productId, productEntity);
	}

	@DeleteMapping(ApiURLConstant.DELETE_PRODUCT_BY_ID)
	@Operation(summary = "delete product by id")
	public ObjectId deleteProductById(@PathVariable("productId") ObjectId productId) {
		return productService.deleteProductById(productId);
	}

	@GetMapping(ApiURLConstant.SEARCH)
	@Operation(summary = "search products by keyword")
	public List<ProductEntity> searchProducts(@RequestParam("nameSubstring") String searchKey) {
		return productService.getProductsByKeyword(searchKey);
	}

	@GetMapping(ApiURLConstant.CATEGORY)
	@Operation(summary = "get products by category")
	public List<ProductEntity> getProductsByCategory(@RequestParam("category") String category) {
		return productService.getProductsByCategory(category);
	}

	@GetMapping(ApiURLConstant.AVAILABILITY)
	@Operation(summary = "get products by availability")
	public List<ProductEntity> getProductsByAvailability(@RequestParam("isActiveProduct") Boolean isActiveProduct) {
		return productService.getProductsByAvailability(isActiveProduct);
	}

	@GetMapping(ApiURLConstant.PRICE_RANGE)
	@Operation(summary = "get products in price range")
	public List<ProductEntity> getProductsInPriceRange(@RequestParam("minPrice") Integer minPrice,
			@RequestParam("maxPrice") Integer maxPrice) {
		return productService.getProductsInPriceRange(minPrice, maxPrice);
	}

	@GetMapping(ApiURLConstant.SORT)
	@Operation(summary = "get sorted products in specific order")
	public List<ProductEntity> getSortedProducts(@RequestParam("fieldName") String fieldName,
			@RequestParam("order") String order) {
		return productService.getSortedProducts(fieldName, order);
	}

}
