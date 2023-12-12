package ru.vadim.spring.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vadim.spring.dao.UserDao;
import ru.vadim.spring.model.User;

@Service
public class UserServiceImpl implements UserService {


  private final UserDao userDao;

  @Autowired
  public UserServiceImpl(UserDao userDao) {
    this.userDao = userDao;
  }

  @Transactional(readOnly = true)
  @Override
  public List<User> getAllUsers() {
    return userDao.getAllUsers();
  }

  @Transactional(readOnly = true)
  @Override
  public User showUserById(Long id) {
    return userDao.showUserById(id);
  }

  @Transactional
  @Override
  public void saveUser(User user) {
    userDao.saveUser(user);
  }

  @Transactional
  @Override
  public void updateUser(Long id, User user) {
    userDao.updateUser(id, user);
  }

  @Transactional
  @Override
  public void deleteUser(Long id) {
    userDao.deleteUser(id);
  }

}
