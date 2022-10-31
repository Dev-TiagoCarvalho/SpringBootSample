package com.findmore.serverapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final String USER_NOT_FOUND_MESSAGE = "The user identified by %s username was not found";
    private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repo) { this.repository = repo; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = repository.findUserByUsername(username);
        User user = opt.orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, username)));
        return new UserDetailsImpl(user);
    }
}
