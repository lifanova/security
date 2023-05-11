package ru.netology.security.service;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.netology.security.model.CustomizedUserDetails;
import ru.netology.security.repository.CustomizedUserCredentialsRepository;

@Data
@Service
public class UserCredentialsService implements UserDetailsService {
    private final CustomizedUserCredentialsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new CustomizedUserDetails(repository.findByLoginEquals(s).orElseThrow(() -> new UsernameNotFoundException("Username not found")));
    }
}
