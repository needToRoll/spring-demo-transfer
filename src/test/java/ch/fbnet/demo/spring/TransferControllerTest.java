package ch.fbnet.demo.spring;

import ch.fbnet.demo.spring.transfer.TranserferApplication;
import ch.fbnet.demo.spring.transfer.model.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.junit.Assert.*;
/**
 * Created by dev on 22.12.16.
 */
@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = TranserferApplication.class)
public class TransferControllerTest {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void doTransaction(){

        String uuid = testRestTemplate.getForObject("/transfer/1/2/100",String.class);
        assertNotNull(uuid);
    }

}
