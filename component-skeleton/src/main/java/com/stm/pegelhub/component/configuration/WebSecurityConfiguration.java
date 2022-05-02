package com.stm.pegelhub.component.configuration;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends KeycloakWebSecurityConfigurerAdapter {
    @Autowired
    private SecurityConfiguration config;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        KeycloakAuthenticationProvider keycloakAuthenticationProvider = keycloakAuthenticationProvider();
        keycloakAuthenticationProvider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
        auth.authenticationProvider(keycloakAuthenticationProvider);
    }

    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>
                .ExpressionInterceptUrlRegistry registry = http
                .cors().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "**").permitAll();

        if (config != null && config.getConfigurations() != null) {
            ExpressionUrlAuthorizationConfigurer<HttpSecurity>.AuthorizedUrl pathMapping;
            for (SecurityConfiguration.Config c : config.getConfigurations()) {
                if (c.hasMethod()) {
                    pathMapping = registry.antMatchers(c.getHttpMethod(), c.getPath());
                } else {
                    pathMapping = registry.antMatchers(c.getPath());
                }

                if (c.getPermit() != null && c.getPermit()) {
                    pathMapping.anonymous();
                } else {
                    pathMapping.hasRole(c.getRole());
                }
            }
        }

        registry.anyRequest().permitAll();
    }
}
