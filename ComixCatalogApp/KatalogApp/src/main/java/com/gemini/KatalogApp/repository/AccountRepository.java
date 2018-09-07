package com.gemini.KatalogApp.repository;
import com.gemini.KatalogApp.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account, Long> {
    //Optional<Account> findByUsername(String username);
    @Query(value = "SELECT * FROM catalog.account", nativeQuery = true)
    List<Account> listAll();
}
