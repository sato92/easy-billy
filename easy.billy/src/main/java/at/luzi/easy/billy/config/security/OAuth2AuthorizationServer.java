package at.luzi.easy.billy.config.security;

public class OAuth2AuthorizationServer {
//@Configuration
//@EnableAuthorizationServer
//public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
//
//	@Override
//	public void configure(final AuthorizationServerSecurityConfigurer security) throws Exception {
//		security
//				.tokenKeyAccess("permitAll()")
//				.checkTokenAccess("isAuthenticated()")
//				.allowFormAuthenticationForClients();
//	}
//
//	@Override
//	public void configure(final ClientDetailsServiceConfigurer clients) throws Exception {
//		clients
//				.inMemory()
//				.withClient("clientapp").secret(passwordEncoder.encode("123456"))
//				.authorizedGrantTypes("password", "authorization_code", "refresh_token")
//				.authorities("READ_ONLY_CLIENT")
//				.scopes("read_profile_info")
//				.resourceIds("oauth2-resource")
//				.redirectUris("http://localhost:8081/login")
//				.accessTokenValiditySeconds(120)
//				.refreshTokenValiditySeconds(240000);
//	}
}
