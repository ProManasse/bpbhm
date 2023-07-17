package com.health.monitor.model;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @NotBlank
	  @Size(max = 20)
	  private String username;

	  @NotBlank
	  @Size(max = 120)
	  private String password;
	  
	  @JsonIgnore
	  @OneToOne(mappedBy = "user")
	  private Profile profile;

	  @ManyToMany(fetch = FetchType.LAZY)
	  @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	  private Set<Role> roles = new HashSet<>();

	  public User() {
			super();
		}

		public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String password,
				Set<Role> roles) {
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.roles = roles;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Set<Role> getRoles() {
			return roles;
		}

		public void setRoles(Set<Role> roles) {
			this.roles = roles;
		}

		public Profile getProfile() {
			return profile;
		}

		public void setProfile(Profile profile) {
			this.profile = profile;
		}
		  
	  
	
	  

}
