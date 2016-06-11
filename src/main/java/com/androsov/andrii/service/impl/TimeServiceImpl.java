package com.androsov.andrii.service.impl;

import com.androsov.andrii.entity.Time;
import com.androsov.andrii.repository.TimeRepository;
import com.androsov.andrii.service.TimeService;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * This service is used for generating and saving random temperature every 10
 * seconds and getting average temperature for the past hour.
 *
 * @author Andrii Androsov
 */
@Service
public class TimeServiceImpl implements TimeService {

    private static final Random RANDOM = new SecureRandom();

    private static final int MAX_TEMPERATURE = 1000;

    private static final Calendar CALENDAR = Calendar.getInstance();

    @Autowired
    private TimeRepository repository;

    @Override
    public Time save(Time time) {
        return repository.save(time);
    }

    @Override
    public Long getTemperatureForLastHour() {
        Date now = new Date();
        CALENDAR.setTime(now);
        CALENDAR.add(Calendar.HOUR, -1);
        return repository.getAverageTemperature(CALENDAR.getTime(), now);
    }

    @Override
    @Scheduled(fixedRate = 10000)
    public void saveRandom() {
        int temperature = RANDOM.nextInt(MAX_TEMPERATURE);
        save(new Time(new Date(), temperature));
    }

}
