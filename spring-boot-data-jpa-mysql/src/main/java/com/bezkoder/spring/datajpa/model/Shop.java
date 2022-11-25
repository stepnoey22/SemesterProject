package com.bezkoder.spring.datajpa.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "shops")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "shop_id")
	private long id;

	@Column(name = "shopName")
	private String shopName;

	@Column(name = "description")
	private String description;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="manager_id")
	private Manager manager;

    @OneToMany(mappedBy = "shop")
    private Set<Book> book;

    @OneToMany(mappedBy = "shop")
    private Set<Food> food;

	public Shop() {

	}

	public Shop(String shopName, String description) {
		this.shopName = shopName;
		this.description = description;
	}

	public Set<Food> getFood() {
        return food;
    }

    public void setFood(Set<Food> food) {
        this.food = food;
    }

    public Set<Book> getBook() {
        return book;
    }

    public void setBook(Set<Book> book) {
        this.book = book;
    }

    public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public long getId() {
		return id;
	}

	public String getshopName() {
		return shopName;
	}

	public void setshopName(String shopName) {
		this.shopName = shopName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Shop [id=" + id + ", shopName=" + shopName + ", desc=" + description + "]";
	}

}
