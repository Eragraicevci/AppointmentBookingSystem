package com.sha.appointment_booking.security.jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends OncePerRequestFilter
{
    @Autowired
    private IJwtProvider jwtProvider;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException
    {
        return request.getRequestURI().startsWith("/api/internal");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException
    {
        Authentication authentication = jwtProvider.getAuthentication(request);

        if (authentication != null && jwtProvider.validateToken(request))
        {
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request, response);
    }
}