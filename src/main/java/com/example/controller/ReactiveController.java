package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class ReactiveController {

    @GetMapping("/reactive")
    public Mono<String> reactiveView(final Model model) {
        // We simulate a slow data stream (1 item per second)
        Flux<String> dataStream = Flux.just("Task A", "Task B", "Task C")
                                      .delayElements(Duration.ofSeconds(1));
        
        // Thymeleaf automatically subscribes to this Flux!
        model.addAttribute("dataStream", dataStream);
        
        return Mono.just("reactive-page"); // Returns view name wrapped in a Mono
    }
}