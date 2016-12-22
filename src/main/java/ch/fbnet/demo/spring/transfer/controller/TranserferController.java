package ch.fbnet.demo.spring.transfer.controller;

import ch.fbnet.demo.spring.transfer.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dev on 22.12.16.
 */
@RestController
@RequestMapping("/")
public class TranserferController {
    @Autowired
    TransferService transferService;
    @GetMapping("transfer/{fromId}/{toId}/{amount}")
    public String tranfer(@PathVariable Long fromId, @PathVariable Long toId, @PathVariable double amount){
        return transferService.transfer(fromId, toId, amount);
    }
}
