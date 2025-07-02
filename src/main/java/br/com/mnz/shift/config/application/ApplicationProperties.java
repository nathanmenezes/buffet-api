package br.com.mnz.shift.config.application;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private final ApplicationProperties.JWT jwt = new ApplicationProperties.JWT();

    @Data
    public static class JWT {
        private String signingKey;
    }
}
