package com.androsov.andrii.repository;

import com.androsov.andrii.entity.Time;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * This JpaRepository is used for getting average temperature for the past hour.
 * @author Andrii Androsov
 */
public interface TimeRepository extends JpaRepository<Time, Long>{
      
    @Query("select avg(t.temperature) from Time t where t.timestamp between :startDate and :endDate ")
    Long getAverageTemperature(@Param("startDate")Date startDate, @Param("endDate")Date endDate);
    
}
