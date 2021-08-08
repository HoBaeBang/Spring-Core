package com.security.securityexam.account;

import com.security.securityexam.form.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
     AccountService accountService;


    @GetMapping("/account/{role}/{userName}/{password}")
    public Account creatAccount(@ModelAttribute Account account){
        return accountService.createNew(account);
    }

}
