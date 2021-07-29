/**
 * 
 */
package in.thirumal.config;

import org.springframework.context.annotation.Configuration;

/**
 * @author Thirumal
 *
 */
@Configuration
//@EnableWebSecurity
public class SecurityConfig { //extends WebSecurityConfigurerAdapter {
	/*
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
			.withUser("thirumal").password("thirumal").roles("ADMIN").roles("ACTUATOR");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().hasRole("ADMIN").and().httpBasic().and().csrf().disable();
    }
    
	@Bean 
	public PasswordEncoder passwordEncoder() { 
		PasswordEncoder encoder = new BCryptPasswordEncoder(); 
		return encoder; 
	}*/
	
}
