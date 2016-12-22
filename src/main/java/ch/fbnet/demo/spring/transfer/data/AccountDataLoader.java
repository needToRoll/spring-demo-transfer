package ch.fbnet.demo.spring.transfer.data;

import ch.fbnet.demo.spring.transfer.model.Account;
import ch.fbnet.demo.spring.transfer.model.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by dev on 22.12.16.
 */

@Component
@Profile("test")
public class AccountDataLoader {
    @Autowired
    AccountRepository accountRepository;

    private final Logger logger = LoggerFactory.getLogger(AccountDataLoader.class);
    @PostConstruct
    public void loadAccounts(){
        accountRepository.save(new Account(500.0));
        accountRepository.save(new Account(1000.0));
        logger.info("Testdata loaded");
    }
}
