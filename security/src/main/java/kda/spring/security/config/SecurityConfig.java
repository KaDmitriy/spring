package kda.spring.security.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
				.anyRequest().authenticated()
			)
			.httpBasic(Customizer.withDefaults())
			.formLogin(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	UserDetailsService userDetailsService() {
		UserDetails userDetails = User.withDefaultPasswordEncoder()
			.username("user")
			.password("111")
			.roles("USER")
			.build();
		
		UserDetails userDetails2 = User.withDefaultPasswordEncoder()
				.username("user2")
				.password("111")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(userDetails, userDetails2);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
}
