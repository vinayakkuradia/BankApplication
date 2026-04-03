package application.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import application.security.entities.AuthRole;

@EnableWebSecurity
public class WebSecConfig extends WebSecurityConfigurerAdapter {

	private UserDetailsService userDetailsService;

	@Autowired
	public WebSecConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println(getPasswordEncoder().encode("manager"));
//		auth.inMemoryAuthentication()
//		.withUser("manager").password(getPasswordEncoder().encode("manager")).roles(AuthRole.ADMIN.getRole())
//		.and()
//		.withUser("clerk").password(getPasswordEncoder().encode("clerk")).roles(AuthRole.USER.getRole());
		auth.userDetailsService(userDetailsService);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/**").hasAnyRole(AuthRole.ADMIN.getPlainRole(), AuthRole.USER.getPlainRole())
			.antMatchers("/**/delete*/**", "/**/approve*/", "/**/reject*/").hasAnyRole(AuthRole.ADMIN.getPlainRole())
				.antMatchers("/").permitAll()
				.antMatchers("error*").permitAll()
			.and()
				.formLogin()
				.loginPage("/")
				.loginProcessingUrl("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.defaultSuccessUrl("/home")
				.permitAll()
			.and()
				.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.clearAuthentication(true)
				.permitAll();
	}

}
