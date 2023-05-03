package com.shopping.ecommerce.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "state", schema="full-stack-ecommerce")
@Getter
@Setter
public class State {
	
	@Id
	@SequenceGenerator(name="state_id_seq",
	   				   sequenceName = "state_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "state_id_seq")
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name="country_id")
	private Country country;

}
