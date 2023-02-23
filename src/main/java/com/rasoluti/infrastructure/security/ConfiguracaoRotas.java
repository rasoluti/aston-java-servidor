package com.rasoluti.infrastructure.security;

import org.springframework.beans.factory.annotation.Autowired;

//@Configuration
//@EnableWebSecurity
public class ConfiguracaoRotas {//implements WebSecurityConfigurerAdapter {

    @Autowired private AutenticacaoServico autenticacaoService;

    private static final String[] AUTH_WHITELIST = {
        "/v2/api-docs", "/v3/api-docs", "/swagger-resources/**", "/swagger-ui/**",
    };

    /* ------------------------------------------------------------------------------------------------------*/

//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers(AUTH_WHITELIST)
//                .permitAll()
//                .antMatchers("/api/**")
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    /* ------------------------------------------------------------------------------------------------------*/
//
//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(autenticacaoService).passwordEncoder(this.passwordEncoder());
//    }
//
//    /* ------------------------------------------------------------------------------------------------------*/
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//    }
//
//    /* ------------------------------------------------------------------------------------------------------*/
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    /* ------------------------------------------------------------------------------------------------------*/



}
