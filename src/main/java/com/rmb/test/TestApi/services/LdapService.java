//package com.rmb.test.TestApi.services;
//
//
//import com.rmb.test.TestApi.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.env.Environment;
//import org.springframework.ldap.core.AttributesMapper;
//import org.springframework.ldap.core.LdapTemplate;
//import org.springframework.ldap.filter.AndFilter;
//import org.springframework.ldap.filter.EqualsFilter;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class LdapService {
//
//    @Autowired
//    LdapTemplate ldapTemplate;
//
//    @Autowired
//    Environment env;
//
//    public User search(String username) {
//        List<User> search = ldapTemplate
//                .search(
//                        "",
//                        // (sAMAccountName=gkasumu)
//                        "(sAMAccountName=" + username + ")"
//                        ,
//                        new AttributesMapper<User>() {
//                            @Override
//                            public User mapFromAttributes(javax.naming.directory.Attributes attributes) throws javax.naming.NamingException {
//                                User user = new User();
//                                user.setUserName((String) attributes.get("sAMAccountName").get());
//                                user.setFirstName((String) attributes.get("givenName").get());
//                                user.setLastName((String) attributes.get("sn").get());
//                                user.setEmail((String) attributes.get("mail").get());
//                                return user;
//                            }
//                        }
//                );
//        if(search.size() > 0 ){
//            return search.get(0);
//        } else {
//            return null;
//        }
//
//    }
//
//    public User searchByEmail(String username) {
//        username = username.toLowerCase();
//        List<User> search = ldapTemplate
//                .search(
//                        "",
//                        // (sAMAccountName=gkasumu)
//                        "(mail=" + username + ")"
//                        ,
//                        new AttributesMapper<User>() {
//                            @Override
//                            public User mapFromAttributes(javax.naming.directory.Attributes attributes) throws javax.naming.NamingException {
//                                User user = new User();
//                                user.setUserName((String) attributes.get("sAMAccountName").get());
//                                user.setFirstName((String) attributes.get("givenName").get());
//                                user.setLastName((String) attributes.get("sn").get());
//                                user.setEmail((String) attributes.get("mail").get());
//                                return user;
//                            }
//                        }
//                );
//        if(search.size() > 0 ){
//            return search.get(0);
//        } else {
//            return null;
//        }
//
//    }
//
//    public boolean authenticate(String username, String password){
//        username = username.toLowerCase();
//        AndFilter filter = new AndFilter();
//        filter.and(new EqualsFilter("sAMAccountName", username));
//        return ldapTemplate.authenticate(env.getProperty("ldap.base"), filter.encode(), password);
//    }
//
//
//
//}
