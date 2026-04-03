package application.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import application.layer.service.contract.UserService;
import application.security.entities.User;

@Primary
@Service
public class BankUserDetailService implements UserDetailsService {

	private UserService userService;
	
	@Autowired
	public BankUserDetailService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userService.findByUsername(username);
		if(user==null)
			throw new UsernameNotFoundException("User not found");
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), 
						AuthorityUtils.createAuthorityList(new String[] {user.getRole()}));
	}

}
