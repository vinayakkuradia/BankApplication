package application.layer.service.contract;

import application.security.entities.User;

public interface UserService {
	public User findByUsername(String username);
	public void addUser(User user);
}
