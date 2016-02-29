package io.egen.feb1europa.service;

import io.egen.feb1europa.entity.User;
import io.egen.feb1europa.exception.UserAlreadyExistsException;
import io.egen.feb1europa.exception.UserNotFoundException;
import io.egen.feb1europa.repository.UserRepositroy;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositroy dao;
	
	@Override
	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	@Override
	public User findUserById(String id) throws UserNotFoundException {
		User user =  dao.findUserById(id);
		if(user == null) {
			throw new UserNotFoundException();
		}
		else {
			return user;
		}
	}

	@Override
	public User findUserByEmail(String email) throws UserNotFoundException {
		User user = dao.findUserByEmail(email);
		if(user == null) {
			throw new UserNotFoundException();
		}
		else {
			return user;
		}
	}

	@Override
	public User createUser(User user) throws UserAlreadyExistsException {
		User existing =  dao.findUserByEmail(user.getEmail());
		if(existing == null) {
			return dao.createUser(user);
		}
		else {
			throw new UserAlreadyExistsException();
		}
	}

	@Override
	public User updateUser(String id, User user) throws UserNotFoundException {
		User existing =  dao.findUserById(id);
		if(existing == null) {
			throw new UserNotFoundException();
		}
		else {
			return dao.updateUser(user);
		}
	}

	@Override
	public void deleteUser(String id) throws UserNotFoundException {
		User existing =  dao.findUserById(id);
		if(existing == null) {
			throw new UserNotFoundException();
		}
		else {
			dao.deleteUser(existing);
		}
	}
	
}
