package com.sha.appointment_booking.security.jwt;

import com.sha.appointment_booking.security.UserPrinciple;
import com.sha.appointment_booking.util.SecurityUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Slf4j
public class InternalApiAuthenticationFilter extends OncePerRequestFilter {

    private final String accessKey;

    public InternalApiAuthenticationFilter(String accessKey)
    {
        this.accessKey = accessKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)           throws ServletException, IOException
    {
        try
        {
            String requestKey = SecurityUtils.extractAuthTokenFromRequest(request);

            if (requestKey == null || !requestKey.equals(accessKey))
            {
                log.warn("Internal key endpoint requested without/wrong key uri: {}", request.getRequestURI());
                throw new RuntimeException("UNAUTHORIZED");
            }

            UserPrinciple user = UserPrinciple.createSuperUser();
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        catch (Exception ex)
        {
            log.error("Could not set user authentication in security context", ex);
        }

        filterChain.doFilter(request, response);
    }
}