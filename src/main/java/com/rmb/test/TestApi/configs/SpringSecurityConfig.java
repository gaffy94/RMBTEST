//package com.rmb.test.TestApi.configs;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
//
//@Order(SecurityProperties.BASIC_AUTH_ORDER)
//@ComponentScan("com.rmb.test")
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private CustomAuthenticationProvider authProvider;
//    @Autowired
//    private RESTAuthenticationEntryPoint authenticationEntryPoint;
//    @Autowired
//    private RESTAuthenticationFailureHandler authenticationFailureHandler;
//    @Autowired
//    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
//
//
//    @Value("${enable-csrf}")
//    private boolean csrfEnabled;
//
//    @Override
//    protected void configure(
//            AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.authenticationProvider(authProvider);
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/api/**").authenticated().and().httpBasic();
//        http.logout()
//                .invalidateHttpSession(true)
//                .deleteCookies("SESSION")
//                .clearAuthentication(true)
//                .logoutSuccessHandler((new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)));
//        if(!csrfEnabled)
//        {
//            http.csrf().disable();
//        }
//    }
//
//    @SuppressWarnings("deprecation")
//    @Bean
//    public static NoOpPasswordEncoder passwordEncoder() {
//        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//    }
//}
