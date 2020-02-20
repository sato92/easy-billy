package at.luzi.easy.billy.config.security;

public class SecurityConfig {
//@Configuration
//@Order(1)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(final HttpSecurity http) throws Exception {
//		http
//				.antMatcher("/**")
//				.authorizeRequests()
//				.antMatchers("/oauth/authorize**", "/login**", "/error**")
//				.permitAll()
//				.and()
//				.authorizeRequests()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin().permitAll();
//	}
//
//	@Override
//	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//		auth
//				.inMemoryAuthentication()
//				.withUser("humptydumpty").password(passwordEncoder().encode("123456")).roles("USER");
//	}
//
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
}