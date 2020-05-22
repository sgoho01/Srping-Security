package com.ghsong.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()    // 다음 리퀘스트에 대한 권한 체크
                // 해당 리퀘스트는 누구나 접근가능
                .antMatchers("/", "/sign-up", "/auth", "/auth").permitAll()
                // admin으로 시작하는 리퀘스트는 ADMIN 권한을 가진 사용자만 접근가능
                .antMatchers("/admin/**").hasRole("ADMIN")
                // 그외 리퀘스트는 권한을 가진 사용자만 접근가능
                .anyRequest().authenticated()
            .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/main")
            .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
        ;
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                // static 아래의 정적 파일들은 security 제외 처리
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


}
