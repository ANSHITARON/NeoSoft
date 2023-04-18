package com.security.demo.models;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Document(collection = "User")
public class User {


  @Id
  private String username;
  private String password;
  private String role;

  public User() {}
  public User(String username, String password, String role) {
    this.username = username;
    this.password = password;
    this.role=role;
  }
  

  public void setPassword(String password) { this.password = password; }
  public String getPassword() { return password; }
  public void setUsername(String username) { this.username = username; }
  public String getUsername() { return username; }
  
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
  
}