package com.security.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
@Document(collection = "User")
public class User implements UserDetails {

  @Id
  public String username;
  @Field
  public String password;
  @Field
  public String role;

  public User() {}
  public User( String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role=role;
  }
  public void setPassword(String password) { this.password = password; }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  public String getPassword() { return password; }
  public void setUsername(String username) { this.username = username; }
  public String getUsername() { return username; }


  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
  
}