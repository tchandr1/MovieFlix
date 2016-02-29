package io.egen.feb1europa.service;

import io.egen.feb1europa.entity.User;
import io.egen.feb1europa.exception.UserAlreadyExistsException;
import io.egen.feb1europa.exception.UserNotFoundException;

import java.util.List;

public interface UserService {

	List<User> findAllUsers();

	User findUserById(String id) throws UserNotFoundException;

	User findUserByEmail(String email) throws UserNotFoundException;

	User createUser(User user) throws UserAlreadyExistsException;

	User updateUser(String id, User user) throws UserNotFoundException;

	void deleteUser(String id) throws UserNotFoundException;

}
