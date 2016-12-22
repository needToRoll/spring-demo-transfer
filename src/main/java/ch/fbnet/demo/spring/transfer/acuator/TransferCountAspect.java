package ch.fbnet.demo.spring.transfer.acuator;

import jdk.nashorn.internal.scripts.JO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

/**
 * Created by dev on 22.12.16.
 */
@Aspect
@Component
public class TransferCountAspect {
    private final CounterService counterService;

    @Autowired
    public TransferCountAspect(CounterService counterService) {
        this.counterService = counterService;
    }
    @AfterReturning("execution(* ch.fbnet.demo.spring.transfer.service.TransferService+.*(..)")
    public void afterSuccessfulTransferCall(JoinPoint joinPoint){
        counterService.increment(joinPoint.getSignature().getName());

    }
}
