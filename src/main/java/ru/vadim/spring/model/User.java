package ru.vadim.spring.model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotEmpty(message = "Нельзя оставлять поле пустым")
  @Size(min = 2, max = 15, message = "Имя должно быть не меньше 2 и не больше 15 символов")
  @Column(name = "name")
  private String name;

  @Min(value = 0, message = "Возраст долже быть больше указанного вами")
  @Column(name = "age")
  private int age;

  @NotEmpty(message = "Нельзя оставлять поле пустым")
  @Email(message = "Формат email не верный")
  @Column(name = "email")
  private String email;

  public User(int id, String name, int age, String email) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id && age == user.age && Objects.equals(name, user.name)
        && Objects.equals(email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age, email);
  }
}
