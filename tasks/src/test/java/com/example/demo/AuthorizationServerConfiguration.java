package com.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;


@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private static String REALM="MY_OAUTH_REALM";

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private UserApprovalHandler userApprovalHandler;

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		clients.inMemory()
		.withClient("blueclient")
		.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
		.scopes("read", "write", "trust")
		.secret("blueclient@COM2107")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(7200)  //Access token is only valid for 5 minutes.
		.and()
		.withClient("trusted_client")
		.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
		.scopes("read", "write", "trust")
		.secret("redclient@COM2017")
		.accessTokenValiditySeconds(3600)
		.refreshTokenValiditySeconds(7200);//Access token is only valid for 5 minutes.
	}

	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
		.authenticationManager(authenticationManager);
	}

	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.realm(REALM+"/client");
	}

}