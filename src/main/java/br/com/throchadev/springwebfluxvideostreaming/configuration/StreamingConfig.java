package br.com.throchadev.springwebfluxvideostreaming.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StreamingConfig {

    @Value("${path.video}")
    private String path;

    public String getPath() {
        return path;
    }
}
