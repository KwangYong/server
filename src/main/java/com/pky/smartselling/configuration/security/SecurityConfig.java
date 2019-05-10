package com.pky.smartselling.configuration.security;

import com.pky.smartselling.configuration.filter.FirebaseFilter;
import com.pky.smartselling.domain.employee.EmployeeType;
import com.pky.smartselling.service.FirebaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    FirebaseService firebaseService;

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            // other public endpoints of your API may be appended to this array
            "/api/v1/employee/signIn"
    };

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http.addFilterBefore(new FirebaseFilter(firebaseService, employeeService), BasicAuthenticationFilter.class).authorizeRequests()
            .antMatchers(AUTH_WHITELIST).permitAll()
            .antMatchers( "/admin/**").hasAuthority(EmployeeType.ADMIN.name())
            .antMatchers( "/v1/**").hasAuthority(EmployeeType.USER.name())
            .and()
                .csrf().disable()
                .cors().disable();



    }
}