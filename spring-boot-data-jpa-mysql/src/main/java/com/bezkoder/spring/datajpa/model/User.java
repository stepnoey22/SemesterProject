package com.bezkoder.spring.datajpa.model;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
	private long id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "published")
	private boolean published;

    @OneToMany(mappedBy = "user")
    private Set<Tutorial> tutorial;
	public User() {

	}

	public User(String name, String description, boolean published) {
		this.name = name;
		this.description = description;
		this.published = published;
	}

    

	public Set<Tutorial> getTutorial() {
        return tutorial;
    }

    public void setTutorial(Set<Tutorial> tutorial) {
        this.tutorial = tutorial;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", desc=" + description + ", published=" + published + "]";
	}

}

