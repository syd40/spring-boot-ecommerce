package com.shopping.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "address", schema="full-stack-ecommerce")
@Getter
@Setter
public class Address {
	
	@Id
	@SequenceGenerator(name="address_id_seq",schema="full-stack-ecommerce",
					   sequenceName = "full-stack-ecommerce.address_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "address_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "zip_code")
	private String zipCode;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Order order;
	
}
