package com.androsov.andrii.entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This entity class fully maps database structure.
 * @author Andrii Androsov
 */
@Entity
@Table(name="time")
public class Time {
    
    @Id
    @Column(name="timecolumn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    
    @Column
    private int temperature;

    public Time() {
    }
    
    public Time(Date timeStamp, int temperature) {
        this.timestamp = timeStamp;
        this.temperature = temperature;
    }

    public Date getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timestamp = timeStamp;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.timestamp);
        hash = 29 * hash + this.temperature;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Time other = (Time) obj;
        if (this.temperature != other.temperature) {
            return false;
        }
        if (!Objects.equals(this.timestamp, other.timestamp)) {
            return false;
        }
        return true;
    }
    
}
