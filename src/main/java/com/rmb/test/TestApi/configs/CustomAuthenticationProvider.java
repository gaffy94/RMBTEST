package com.rmb.test.TestApi.configs;


import com.rmb.test.TestApi.services.LdapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
  @Autowired
    LdapService ldapService;
    private static final Logger LOGGER = Logger.getLogger(CustomAuthenticationProvider.class.getName());
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
        String username = auth.getName();
        String password = auth.getCredentials()
                .toString();
//        if(ldapService.authenticate(username,password)) {
        boolean te = true;
        LOGGER.info("Username: "+ username+ " Password : "+password);
        if(te) {
            return new CustomUserObj(
                    username, password, new ArrayList<>());
        } else {
            throw new
                    BadCredentialsException("External system authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
