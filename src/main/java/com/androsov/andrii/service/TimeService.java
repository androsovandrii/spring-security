package com.androsov.andrii.service;

import com.androsov.andrii.entity.Time;

/**
 * This interface is used for describing main methods for generating and saving
 * random temperature every 10 seconds and getting average temperature for the
 * past hour.
 *
 * @author Andrii Androsov
 */
public interface TimeService {

    /**
     * Saves a specified entity.
     *
     * @param entity
     * @return the saved entity
     */
    Time save(Time time);

    /**
     * Method returns average temperature from database for last hour.
     *
     * @return Long value
     */
    Long getTemperatureForLastHour();

    /**
     * Method saves random temperature value every 10 seconds.
     */
    void saveRandom();
}
