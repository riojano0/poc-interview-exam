package com.montivero.poc.exam;

import com.montivero.poc.exam.config.ApplicationProperties;
import com.montivero.poc.exam.config.ProfilePropertiesHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MapPropertySource;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@ComponentScan("com.montivero.poc.exam")
@EnableConfigurationProperties(ApplicationProperties.class)
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);
    private static final String WELCOME_MESSAGE = System.lineSeparator()
            + " -------------------- "
            + System.lineSeparator()
            + "Application: {}"
            + System.lineSeparator()
            + "Spring-Profile: {}"
            + System.lineSeparator()
            + "Local: {}"
            + System.lineSeparator()
            + "External: {}"
            + System.lineSeparator()
            + " -------------------- ";

    public static void main(final String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        Environment env = app.run(args).getEnvironment();
        MapPropertySource mapPropertySource = ProfilePropertiesHelper.getMapPropertySource(env);
        log.info(WELCOME_MESSAGE,
                mapPropertySource.getProperty("spring.application.name"),
                env.getActiveProfiles(),
                "localhost:" + mapPropertySource.getProperty("spring.server.port"),
                InetAddress.getLocalHost().getHostAddress() + ":" + mapPropertySource.getProperty("spring.server.port")
        );
    }
}
