package com.gemini.KatalogApp.service;

import com.gemini.KatalogApp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("LoginValidationService")
public class LoginValidationService {

    @Autowired
    private AccountRepository accountRepository;

    public boolean accountValidator(String username, String password){

        for (int i = 0; i < accountRepository.listAll().size(); i++) {
            if (accountRepository.listAll().get(i).getUsername().matches(username) &&
                    (accountRepository.listAll().get(i).getPassword().matches(password))){
                return true;
            }
        }
        return false;
    }
}
