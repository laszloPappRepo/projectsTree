package com.gemini.KatalogApp.service;

import com.gemini.KatalogApp.repository.ComixCoverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchHandlingService {

    @Autowired
    ComixCoverRepo comixCoverRepo;

    public Boolean getTitleIfExist(String title) {
        for (int i = 0; i < comixCoverRepo.listAll().size(); i++) {
            if (comixCoverRepo.listAll().get(i).getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public Boolean getTitleIfContains(String title){
        for (int i = 0; i < comixCoverRepo.listAll().size(); i++) {
            if (comixCoverRepo.listAll().get(i).getTitle().contains(title)){
                return false;
            }
        }
        return true;
    }
}
