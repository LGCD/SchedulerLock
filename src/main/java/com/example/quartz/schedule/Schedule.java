package com.example.quartz.schedule;

import net.javacrumbs.shedlock.core.SchedulerLock;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author ligang
 * @date 2018-11-05
 */
@Component
public class Schedule {

    private final static Logger logger = LoggerFactory.getLogger(Schedule.class);

    @Scheduled(cron = "0/2 * * * * ?")
    @SchedulerLock(name = "reportCurrentTime", lockAtLeastFor = 1 * 1000)
    public void reportCurrentTime() {
        logger.info("{}", DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
    }

}


