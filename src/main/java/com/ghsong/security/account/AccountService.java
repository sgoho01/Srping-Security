package com.ghsong.security.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AccountService implements UserDetailsService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByEmail(username);
        if(account == null) {
            throw new UsernameNotFoundException(username);
        }
        return new AccountUser(account);
    }


    public Account signUp(AccountSignUpDto accountSignUpDto) {
        accountSignUpDto.setPassword(passwordEncoder.encode(accountSignUpDto.getPassword()));
        return accountRepository.save(accountSignUpDto.toEntity());
    }

}
