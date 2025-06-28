package br.com.mnz.buffet;

import br.com.mnz.buffet.config.application.ApplicationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class BuffetApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuffetApplication.class, args);
    }

}
