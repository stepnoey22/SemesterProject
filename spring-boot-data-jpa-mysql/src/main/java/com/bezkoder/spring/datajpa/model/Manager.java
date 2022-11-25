package com.bezkoder.spring.datajpa.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "managers")
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manager_id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "lastname")
	private String lastname;


    @OneToMany(mappedBy = "manager")
    private Set<Shop> shop;

	public Manager() {

	}

	public Manager(String name, String lastname) {
		this.name = name;
		this.lastname = lastname;
	}

	public Set<Shop> getShop() {
        return shop;
    }

    public void setShop(Set<Shop> shop) {
        this.shop = shop;
    }

    public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", lastname=" + lastname + "]";
	}

}


