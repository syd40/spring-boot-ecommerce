package com.shopping.ecommerce.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "product_category", schema="full-stack-ecommerce")
@Getter
@Setter
public class ProductCategory {
	
	@Id
	@SequenceGenerator(name="product_category_id_seq",
	   				   sequenceName = "product_category_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "product_category_id_seq")
	private Long id;
	
	@Column(name = "category_name")
	private String categoryName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private Set<Product> products;
	
}
