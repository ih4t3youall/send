package ar.com.commons.send.domain;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

	// An autogenerated id (unique for each user in the db)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	@Expose
	private long id;
	@Expose
	@Column(unique = true)
	private String name;
	@Expose
	@Column(name = "active")
	private int active;
	@Expose
	private String password;
	@Expose
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	@Expose
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Category> category;
	

	public List<Category> getCategory() {
		return category;
	}

	public void setCategory(List<Category> category) {
		this.category = category;
	}
	
	public void addCategory(Category categoryToAdd) {
		
		if(category == null) {
			category = new ArrayList<Category>();
		}
		
		category.add(categoryToAdd);
		
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public User() {

	}

	public User(long id) {

		this.id = id;

	}

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}