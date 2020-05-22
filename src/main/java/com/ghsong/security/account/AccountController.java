package com.ghsong.security.account;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/sign-up")
    public String signUpForm() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(AccountSignUpDto accountSignUpDto) {
        accountService.signUp(accountSignUpDto);
        return "redirect:/login";
    }

    @GetMapping("/auth")
    public String auth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getPrincipal().toString());
        System.out.println(authentication.getAuthorities());
        return "index";
    }

}
