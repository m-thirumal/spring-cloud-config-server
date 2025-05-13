/**
 * 
 */
package com.thirumal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Thirumal
 * Web security is enabled for the purpose of 
 * 	- encrypting/de-crypting the properties values that are encrypted at-rest
 * 	- Securing the application
 */
@Configuration
@EnableWebSecurity//(debug = true)
public class SecurityConfig { //extends WebSecurityConfigurerAdapter {

	/**
	 * Development security: permit all
	 * @param httpSecurity
	 * @return
	 * @throws Exception
	 */
	@Bean
	@Profile("DEV") 
    SecurityFilterChain developmentSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/**").permitAll() //To disable login
            )        	
            .csrf(csrf -> csrf.disable())
            .formLogin(form -> form.disable()) //To disable login
             .httpBasic(httpBasic -> httpBasic.disable()); //To disable login
        return httpSecurity.build();
    }
	
	/**
	 * Production security: require authentication
	 * @param httpSecurity
	 * @return
	 * @throws Exception
	 */
	@Bean
	@Profile("PRO")
    SecurityFilterChain productionSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeHttpRequests(authz -> authz
               .anyRequest().authenticated()
            )        	
            .csrf(csrf -> csrf.disable())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();
    }
	
	@Bean
	InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails user1 = User.withUsername("admin").password(passwordEncoder.encode("admin")) 
				.roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user1);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}

	
}
