package com.bach.qlkh.configuration;

import com.bach.qlkh.model.Customer;
import com.bach.qlkh.model.Manager;
import com.bach.qlkh.repository.CustomerRepository;
import com.bach.qlkh.repository.ManagerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CustomUserServiceDetail implements UserDetailsService {

    ManagerRepository managerRepository;
    CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Manager manager = managerRepository.findByManagerName(username);
        if (manager != null) {
            return new User(
                    manager.getManagerName(),
                    manager.getPassword(),
                    createAuthorities("ROLE_ADMIN")
            );
        }

        Customer customer = customerRepository.findByUsername(username);
        if (customer != null) {
            return new User(
                    customer.getUsername(),
                    customer.getPassword(),
                    createAuthorities("ROLE_CUSTOMER")
            );
        }
        throw new UsernameNotFoundException("Không tìm thấy người dùng: " + username);
    }

    private List<SimpleGrantedAuthority> createAuthorities(String role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role));
    }

}
