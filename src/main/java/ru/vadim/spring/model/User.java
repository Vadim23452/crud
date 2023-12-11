package ru.vadim.spring.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty(message = "The field must not be empty")
  @Size(min = 2, max = 15, message = "Must be from 2 to 15 character")
  @Column(name = "name")
  private String name;

  @NotEmpty(message = "The field must not be empty")
  @Size(min = 2, max = 15, message = "Must be from 2 to 15 character")
  @Column(name = "last_name")
  private String lastName;

  @Min(value = 5, message = "Error in entering age")
  @Column(name = "age")
  private int age;

  @NotEmpty(message = "The field must not be empty")
  @Email(message = "Not Valid email")
  @Column(name = "email")
  private String email;

  @Column(name = "address")
  private String address;

  public User(Long id, String name, int age, String email, String address) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
    this.address = address;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
