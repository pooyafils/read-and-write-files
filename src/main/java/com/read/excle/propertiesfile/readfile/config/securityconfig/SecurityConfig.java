package com.read.excle.propertiesfile.readfile.config.securityconfig;


import com.read.excle.propertiesfile.readfile.jwt.JwtConfig;
import com.read.excle.propertiesfile.readfile.jwt.JwtTokenVerifier;
import com.read.excle.propertiesfile.readfile.jwt.JwtUsernamePasswordAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.crypto.SecretKey;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    UserDetailServiceImp userDetailServiceImp;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;
    public SecurityConfig(PasswordEncoder passwordEncoder,
                          UserDetailServiceImp userDetailServiceImp, JwtConfig jwtConfig,SecretKey secretKey ) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailServiceImp=userDetailServiceImp;
        this.jwtConfig=jwtConfig;
        this.secretKey=secretKey;
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable().and().
                sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
                addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(),jwtConfig,secretKey)).
               addFilterAfter(new JwtTokenVerifier(secretKey,jwtConfig), JwtUsernamePasswordAuthenticationFilter.class).
                httpBasic().and().authorizeRequests()
                .antMatchers("/excel/**").hasAuthority("canReadUser")
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .and().csrf().disable();
    }
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(passwordEncoder);
        authenticationProvider.setUserDetailsService(userDetailServiceImp);
        return authenticationProvider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }
}
