package com.ghsong.security.account;

import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Getter
public class User extends org.springframework.security.core.userdetails.User {

    private Account account;

    public User(Account account) {
        super(account.getEmail(), account.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_USER")));
        this.account = account;
    }
}
