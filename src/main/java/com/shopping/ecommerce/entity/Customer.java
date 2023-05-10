package com.shopping.ecommerce.entity;

import java.util.HashSet;
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
@Table(name = "customer", schema="full-stack-ecommerce")
@Getter
@Setter
public class Customer {
	
	@Id
	@SequenceGenerator(name="customer_id_seq",schema = "full-stack-ecommerce",
					   sequenceName = "full-stack-ecommerce.customer_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "customer_id_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders = new HashSet<>();
	
	public void add(Order order) {
		
		if(order != null) {
			if(orders == null) {
				orders = new HashSet<>();
			}
			orders.add(order);
			order.setCustomer(this);
		}
		
	}
	
}
