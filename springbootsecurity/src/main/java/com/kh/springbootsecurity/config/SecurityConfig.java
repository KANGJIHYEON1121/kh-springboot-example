package com.kh.springbootsecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.springbootsecurity.common.security.CustomAccessDeniedHandler;
import com.kh.springbootsecurity.common.security.CustomLoginSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
// SpringBootWebSecurityConfiguration.SecurityFilterChainConfiguration: 자동설정
// 비활성화
// 직접 설정
public class SecurityConfig {
    @Autowired
    private DataSource dataSource;

    @Bean
    // SpringBootWebSecurityConfiguration.SecurityFilterChainConfiguration: 자동설정
    // 비활성화
    // 직접 설정
    SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        log.info("security setting start");

        // csrf 토큰 비활성화
        http.csrf().disable();

        // 로그인 인가정책
        http.authorizeRequests().requestMatchers("/board/list").permitAll();
        http.authorizeRequests().requestMatchers("/board/register").hasRole("MEMBER");
        http.authorizeRequests().requestMatchers("/notice/list").permitAll();
        http.authorizeRequests().requestMatchers("/notice/register").hasRole("ADMIN");

        // 로그인 (인증, 인가) 정책 실패 할 경우 (403 페이지, formLogin()) => 직접 설정 인증,인가 실패 화면 출력
        // 접근 거부 처리자에 대한 페이지 이동 URI를 지정
        // http.exceptionHandling().accessDeniedPage("/accessError");

        // 등록한 CustomAccessDeniedHandler.java를 접근 거부 처리자로 지정한다.
        http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());

        // 로그인 인증청책 (로그인처리 자동설정 화면 사용, 이후 만든 로그인 화면 대체)
        // userName : test, password : 123456, role : Manager
        // 1) http.formLogin();

        // 사용자가 정의한 로그인 페이지를 요청
        // 2) http.formLogin().loginPage("/login");

        // 개발자가 정의한 로그인 페이지의 URI를 지정한다.
        // 로그인 성공 후 처리를 담당하는 처리자로 지정한다.
        // 로그인 성공 후(시큐리티가 사용자정보를 이미 셋팅완료했다. 인증, 인가설정) 처리를 담당하는 처리자로 지정한다.
        http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());

        // 로그아웃 처리를 위한 URI를 지정하고, 로그아웃한 후에 세션을 무효화 한다.
        http.logout().logoutUrl("/logout").invalidateHttpSession(true);

        return http.build();
    }

    // @Autowired
    // protected void configure(AuthenticationManagerBuilder auth) throws Exception
    // {
    // // 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다.
    // auth.inMemoryAuthentication().withUser("member").password("{noop}123456").roles("MEMBER");
    // auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN",
    // "MEMBER");
    // }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
    }

    // 스프링 시큐리티의 UserDetailsService를 구현한 클래스를 빈으로 등록한다.
    @Bean
    public UserDetailsService createUserDetailsService() {
        return new CustomUserDetailsService();
    }

    // 사용자가 정의한 비번 암호화 처리기를 빈으로 등록한다.
    @Bean
    public PasswordEncoder createPasswordEncoder() {
        return new CustomNoOpPasswordEncoder();
    }

    // CustomLoginSuccessHandler를 빈으로 등록한다.
    @Bean
    public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }

    // CustomAccessDeniedHandler를 빈으로 등록한다.
    @Bean
    public AccessDeniedHandler createAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    // CustomAccessDeniedHandler를 빈으로 등록한다.
    @Bean
    public AccessDeniedHandler createAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    // CustomLoginSuccessHandler를 빈으로 등록한다.
    @Bean
    public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
        return new CustomLoginSuccessHandler();
    }
}
