package tr.com.obss.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("yasin").password("{noop}123456").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("{noop}123456").roles("DBA");
	}

//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')").antMatchers("/dba/**")
//				.access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')").and().formLogin().and().csrf().disable();
//
//	}
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        
     http
        .cors().and().authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().and()
        .authorizeRequests()
        .antMatchers("**").permitAll()
        .and()
        .csrf().disable();
    }
    
    @Bean
    public WebMvcConfigurer corsConfigurer() {
      return new WebMvcConfigurerAdapter() {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
          registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "GET", "PUT",
              "DELETE");
        }
      };
    }
}


