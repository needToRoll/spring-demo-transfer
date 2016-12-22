package ch.fbnet.demo.spring.transfer.service.internal;

import ch.fbnet.demo.spring.transfer.model.Account;
import ch.fbnet.demo.spring.transfer.model.AccountRepository;
import ch.fbnet.demo.spring.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by dev on 22.12.16.
 */
@Component
public class DefaultTransferService implements TransferService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public String transfer(Account source, Account target, double balance) {
        source.debit(balance);
        target.credit(balance);
        accountRepository.save(source);
        accountRepository.save(target);
        return UUID.randomUUID().toString();
    }

    @Override
    public String transfer(Long fromId, Long toId, double amount) {
        return transfer(accountRepository.findOne(fromId),accountRepository.findOne(toId), amount);
    }
}
