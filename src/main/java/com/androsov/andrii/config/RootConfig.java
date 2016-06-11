package com.androsov.andrii.config;

import org.springframework.context.annotation.ComponentScan;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Configure root context.
 * @author Andrii Androsov
 */
@Configuration
@ComponentScan(basePackages = {"com.androsov.andrii"})
@Import(PersistentContext.class)
@EnableScheduling
public class RootConfig {
}
