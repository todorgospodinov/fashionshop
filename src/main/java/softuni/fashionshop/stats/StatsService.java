package softuni.fashionshop.stats;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    private AtomicInteger requestCount = new AtomicInteger(0);
    private Instant startedOn = Instant.now();

    public void incRequestCount() {
        requestCount.incrementAndGet();
    }

    public int getRequestCount() {
        return requestCount.intValue();
    }

    public Instant getStartedOn() {
        return startedOn;
    }

}