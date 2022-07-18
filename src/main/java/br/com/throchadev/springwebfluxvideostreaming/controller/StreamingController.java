package br.com.throchadev.springwebfluxvideostreaming.controller;

import br.com.throchadev.springwebfluxvideostreaming.service.StreamingService;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/video")
public class StreamingController {

    private final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping(value = "/{title}", produces = "video/mp4")
    public Mono<Resource> getVideo(@PathVariable String title, @RequestHeader("Range") String range) {
        return streamingService.getVideo(title);
    }
}
