package ru.vadim.spring.dao;

import java.util.List;
import ru.vadim.spring.model.User;

public interface UserDao {

   List<User> allUsers();

   User showUserById(Long id);

   void saveUser(User user);

   void updateUser(Long id, User user);

   void deleteUser(Long id);

}
