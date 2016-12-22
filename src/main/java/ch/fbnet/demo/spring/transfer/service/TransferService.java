package ch.fbnet.demo.spring.transfer.service;

import ch.fbnet.demo.spring.transfer.model.Account;

/**
 * Created by dev on 22.12.16.
 */
public interface TransferService {
    public String transfer(Account source, Account target, double balance);
    public String transfer(Long fromId, Long toId, double amount);
}
