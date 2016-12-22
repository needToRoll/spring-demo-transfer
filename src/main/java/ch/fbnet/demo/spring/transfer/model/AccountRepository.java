package ch.fbnet.demo.spring.transfer.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dev on 22.12.16.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {}
