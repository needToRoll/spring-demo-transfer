package ch.fbnet.demo.spring.transfer.acuator;

import ch.fbnet.demo.spring.transfer.model.Account;
import ch.fbnet.demo.spring.transfer.model.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

/**
 * Created by dev on 22.12.16.
 */
@Component
public class AcuatorAccountNumerInfoContributer implements InfoContributor {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("NumberOfAccounts",accountRepository.count());
    }
}
