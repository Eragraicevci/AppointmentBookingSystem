package com.sha.appointment_booking.security;
import com.sha.appointment_booking.model.Role;
import com.sha.appointment_booking.model.User;
import com.sha.appointment_booking.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder //produces the code automatically using the Builder pattern

public class UserPrinciple implements UserDetails {

        private Long id;
        private String username;
        transient private String password;
        transient private User user;
        private Set<GrantedAuthority> authorities;

        public static UserPrinciple createSuperUser()
        {
                Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));

                return UserPrinciple.builder()
                        .id(-1L)
                        .username("system-administrator")
                        .authorities(authorities)
                        .build();
        }
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities()
        {
            return authorities;
        }

        @Override
        public String getPassword()
        {
            return password;
        }

        @Override
        public String getUsername()
        {
            return username;
        }

        @Override
        public boolean isAccountNonExpired()
        {
            return true;
        }

        @Override
        public boolean isAccountNonLocked()
        {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired()
        {
            return true;
        }

        @Override
        public boolean isEnabled()
        {
            return true;
        }
    }