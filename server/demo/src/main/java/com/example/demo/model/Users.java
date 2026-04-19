package com.example.demo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="users")
public class Users {

  private String fullname;
  private String email;
  private int role;
  private String password;

  @DynamoDBAttribute(attributeName="fullname")
  public String getFullname() { return fullname; }
  public void setFullname(String fullname) { this.fullname = fullname; }

  @DynamoDBHashKey(attributeName="email")
  public String getEmail() { return email; }
  public void setEmail(String email) { this.email = email; }

  @DynamoDBAttribute(attributeName="role")
  public int getRole() { return role; }
  public void setRole(int role) { this.role = role; }

  @DynamoDBAttribute(attributeName="password")
  public String getPassword() { return password; }
  public void setPassword(String password) { this.password = password; }
}