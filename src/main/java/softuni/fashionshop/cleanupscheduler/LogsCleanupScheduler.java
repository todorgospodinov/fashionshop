package softuni.fashionshop.cleanupscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import softuni.fashionshop.repository.LogRepository;

import java.time.Instant;
import java.time.LocalDateTime;

import static java.time.temporal.ChronoUnit.HOURS;

@Component
public class LogsCleanupScheduler {

    private final LogRepository logRepository;

    public LogsCleanupScheduler(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Scheduled(cron = "0 0 2 * * ?")
    public void cleanUpOldLogs() {
        Instant deleteUpTo = Instant.now().minus(168, HOURS);
        logRepository.deleteByDateTimeBefore(deleteUpTo);
    }

}
