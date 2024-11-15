package com.main.nimap.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	public int category_id;

	public String category_name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Product> product = new ArrayList<>();
	
	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int id) {
		this.category_id = id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String name) {
		this.category_name = name;
	}

}
