package kz.bisen.springcourse.springpublishingwebapp.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

@Slf4j
public class BookAmountChangeScheduler {

    @Scheduled(fixedRate = 1000, initialDelay = 1000)
    public void schedule() {
        LocalDateTime current = LocalDateTime.now();



        log.info("Done, time: " + current);
    }
}
