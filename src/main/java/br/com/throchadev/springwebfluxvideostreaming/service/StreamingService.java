package br.com.throchadev.springwebfluxvideostreaming.service;

import br.com.throchadev.springwebfluxvideostreaming.configuration.StreamingConfig;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class StreamingService {

    private final StreamingConfig streamingConfig;
    private final ResourceLoader resourceLoader;

    public StreamingService(StreamingConfig streamingConfig, ResourceLoader resourceLoader) {
        this.streamingConfig = streamingConfig;
        this.resourceLoader = resourceLoader;
    }

    public Mono<Resource> getVideo(String title){
        return Mono.fromSupplier(()-> resourceLoader.getResource(String.format(streamingConfig.getPath(), title)));
    }
}
