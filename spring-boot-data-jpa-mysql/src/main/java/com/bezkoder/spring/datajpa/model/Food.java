package com.bezkoder.spring.datajpa.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "foods")
public class Food {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "food_id")
	private long id;

	@Column(name = "foodName")
	private String foodName;

	@Column(name = "description")
	private String description;

    @JsonIgnore
	@ManyToOne
	@JoinColumn(name="shop_id")
	private Shop shop;

	public Food() {

	}

	public Food(String foodName, String description) {
		this.foodName = foodName;
		this.description = description;
	}


	public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public long getId() {
		return id;
	}

	public String getfoodName() {
		return foodName;
	}

	public void setfoodName(String bookName) {
		this.foodName = bookName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Shop [id=" + id + ", bookName=" + foodName + ", desc=" + description + "]";
	}

}


