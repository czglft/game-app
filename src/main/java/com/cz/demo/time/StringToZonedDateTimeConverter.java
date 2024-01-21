package com.cz.demo.time;

import org.modelmapper.AbstractConverter;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class StringToZonedDateTimeConverter extends AbstractConverter<String, ZonedDateTime> {

    private final DateTimeFormatter formatter;

    public StringToZonedDateTimeConverter(String pattern) {
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    protected ZonedDateTime convert(String source) {
        return ZonedDateTime.parse(source, formatter);
    }
}