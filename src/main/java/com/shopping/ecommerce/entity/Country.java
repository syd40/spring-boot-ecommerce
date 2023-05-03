package com.shopping.ecommerce.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "country", schema="full-stack-ecommerce")
@Getter
@Setter
public class Country {
	
	@Id
	@SequenceGenerator(name="country_id_seq",
	   				   sequenceName = "country_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,
					generator = "country_id_seq")
	@Column(name="id")
	private int id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(mappedBy = "country")
	@JsonIgnore
	private List<State> states;
}
