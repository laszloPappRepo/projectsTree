package gemini.superHeroAPI.repository;

import gemini.superHeroAPI.modell.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    @Query(value = "SELECT * FROM superhero.account", nativeQuery = true)
    List<Account> listAll();
}
