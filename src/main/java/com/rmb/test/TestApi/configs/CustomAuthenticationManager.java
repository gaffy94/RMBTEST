package com.rmb.test.TestApi.configs;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;
@Component
public class CustomAuthenticationManager implements AuthenticationManager {
    private static final Logger LOGGER = Logger.getLogger(CustomAuthenticationManager.class.getName());
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal() + "";
        String password = authentication.getCredentials() + "";
        boolean te = true;
        LOGGER.info("Username: "+ username+ " Password : "+password);
        if(te) {
            return new CustomUserObj(
                    username, password, new ArrayList<>());
        } else {
            throw new
                    BadCredentialsException("External system authentication failed");
        }
//        List<Right> userRights = rightRepo.getUserRights(username);
//        return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
    }
}
