package io.schultz.dustin.todoapp.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MaxMemoryHealthIndicator  implements HealthIndicator {

    @Override
    public Health health() {
        boolean invalid = Runtime.getRuntime().maxMemory() < 1000000000;
        Status status = invalid ? Status.DOWN : Status.UP;
        return Health.status(status).build();
    }

}
