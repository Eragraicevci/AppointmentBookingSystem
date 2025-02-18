package com.sha.appointment_booking.security;
import com.sha.appointment_booking.model.User;
import com.sha.appointment_booking.services.IUserService;
import com.sha.appointment_booking.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userService.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

       Set<GrantedAuthority> authorities=Set.of(SecurityUtils.convertToAuthority(user.getRole(). name()));

       return UserPrinciple.builder()
               .user(user).id(user.getId())
               .username(username)
               .password(user.getPassword())
               .authorities(authorities)
               .build();
    }
}
