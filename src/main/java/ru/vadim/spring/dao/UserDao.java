package ru.vadim.spring.dao;

import java.util.List;
import ru.vadim.spring.model.User;

public interface UserDao {

   List<User> allUsers();

   User showUserById(int id);

   void saveUser(User user);

   void updateUser(int id, User user);

   void deleteUser(int id);

}
