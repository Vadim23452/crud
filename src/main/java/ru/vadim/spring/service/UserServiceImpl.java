package ru.vadim.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vadim.spring.dao.UserDao;
import ru.vadim.spring.model.User;

@Component
@Transactional
public class UserServiceImpl implements UserService {


  private UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Transactional(readOnly = true)
  @Override
  public List<User> allUsers() {
    return userDao.allUsers();
  }

  @Transactional(readOnly = true)
  @Override
  public User showUserById(int id) {
    return userDao.showUserById(id);
  }

  @Transactional
  @Override
  public void saveUser(User user) {
    userDao.saveUser(user);
  }

  @Transactional
  @Override
  public void updateUser(int id, User user) {
    userDao.updateUser(id, user);
  }

  @Transactional
  @Override
  public void deleteUser(int id) {
    userDao.deleteUser(id);
  }

}
