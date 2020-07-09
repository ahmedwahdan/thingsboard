package org.thingsboard.server.dao;

import lombok.Data;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Data
@Configuration
public class LocaleConfig {
    private Locale locale;
}
