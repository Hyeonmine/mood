package com.boot.mood.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    @GetMapping("account/accountCreateForm")
    public String createAccount() {
        return "account/accountCreateForm";
    }


}
