package com.ghsong.security.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/user/test")
    public String test() {
        return "test";
    }

    @GetMapping("/admin/test")
    public String admin() {
        return "admin/admin";
    }
}
