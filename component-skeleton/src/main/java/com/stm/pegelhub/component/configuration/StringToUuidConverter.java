package com.stm.pegelhub.component.configuration;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class StringToUuidConverter implements Converter<String, UUID> {
    @Override
    public UUID convert(String uuid) {
        if (uuid == null)
            return null;
        return  UUID.fromString(uuid);
    }
}
