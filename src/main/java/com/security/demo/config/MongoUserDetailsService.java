package com.security.demo.config;



import com.security.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class MongoUserDetailsService implements UserDetailsService{

	@Autowired 
	private UserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.security.demo.models.User user=userRepository.findByUsername(username);
		
		if(user == null) {
	      throw new UsernameNotFoundException("User not found");
	    }
		
		List<SimpleGrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority(user.getRole()));
		
	    return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
