package com.rmb.test.TestApi.models;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class User implements UserDetails, Authentication {
    private String firstName;
    private String lastName;
    private String affiliate;
    private List<String> userActivities = new ArrayList<>();
    private List<String> userRoles = new ArrayList<>();
    private String email;
    private String userName;
    private Map<String, Object> genericAttribute;

    private org.springframework.security.core.userdetails.User user;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAffiliate() {
        return affiliate;
    }

    public void setAffiliate(String affiliate) {
        this.affiliate = affiliate;
    }

    public List<String> getUserScopes() {
        return userActivities;
    }

    public void setUserScopes(List<String> userActivities) {
        this.userActivities = userActivities;
    }

    public List<String> getUserType() {
        return userRoles;
    }

    public void setUserType(List<String> userType) {
        this.userRoles = userType;
    }

    public Map<String, Object> getGenericAttribute() {
        return genericAttribute;
    }

    public void setGenericAttribute(Map<String, Object> genericAttribute) {
        this.genericAttribute = genericAttribute;
    }

    public org.springframework.security.core.userdetails.User getUser() {
        return user;
    }

    public void setUser(org.springframework.security.core.userdetails.User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String toString() {
        return "AimsUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", affiliate='" + affiliate + '\'' +
                ", userScopes='" + userActivities + '\'' +
                ", userType='" + userRoles + '\'' +
                ", genericAttribute=" + genericAttribute +
                ", user=" + user +
                '}';
    }

    @Override
    public String getName() {
        return null;
    }
}
