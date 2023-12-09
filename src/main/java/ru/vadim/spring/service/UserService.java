package ru.vadim.spring.service;

import java.util.List;
import org.springframework.stereotype.Service;
import ru.vadim.spring.model.User;

@Service
public interface UserService {

  List<User> allUsers();

  User showUserById(int id);

  void saveUser(User user);

  void updateUser(int id, User user);

  void deleteUser(int id);

}
