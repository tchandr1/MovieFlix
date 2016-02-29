package io.egen.feb1europa.repository;

import java.util.List;

import io.egen.feb1europa.entity.User;

public interface UserRepositroy {

	public List<User> findAllUsers ();
	public User findUserById(String id);
	public User findUserByEmail(String email);
	public User createUser(User user);
	public User updateUser(User user);
	public void deleteUser(User user);
}
