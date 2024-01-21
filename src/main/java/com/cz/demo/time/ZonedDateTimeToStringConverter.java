package com.cz.demo.time;

import org.modelmapper.AbstractConverter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZonedDateTimeToStringConverter extends AbstractConverter<ZonedDateTime, String> {

    private final DateTimeFormatter formatter;

    public ZonedDateTimeToStringConverter(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    protected String convert(ZonedDateTime source) {
        return source.format(formatter);
    }
}