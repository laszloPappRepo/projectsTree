package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    //Optional<Account> findByUsername(String username);
    @Query(value = "SELECT * FROM superhero.account", nativeQuery = true)
    List<Account> listAll();
}
