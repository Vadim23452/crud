package ru.vadim.spring.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import org.springframework.stereotype.Repository;
import ru.vadim.spring.model.User;

@Repository
public class UserDaoImpl implements UserDao{

  private EntityManager entityManager;

  @PersistenceContext
  public void setEntityManager(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  public List<User> allUsers() {
    return entityManager.createQuery("SELECT u FROM User u",User.class).getResultList();
  }

  @Override
  public User showUserById(int id) {
    return entityManager.find(User.class, id);
  }

  @Override
  public void saveUser(User user) {
    entityManager.persist(user);
  }

  @Override
  public void updateUser(int id, User updatedUser) {
    User userToUpdate = showUserById(id);
    userToUpdate.setName(updatedUser.getName());
    userToUpdate.setAge(updatedUser.getAge());
    userToUpdate.setEmail(updatedUser.getEmail());
    entityManager.merge(userToUpdate);
  }

  @Override
  public void deleteUser(int id) {
    entityManager.remove(entityManager.find(User.class, id));
  }

}
