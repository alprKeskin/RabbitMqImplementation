package io.github.alprkeskin.producermicroservice.rest;

import io.github.alprkeskin.producermicroservice.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @GetMapping("send")
    public void sendMessage(@RequestParam(name = "integer") int sampleIntegerArgument,
                            @RequestParam(name = "string") String sampleStringArgument) {
        log.info("ProducerController::sendMessage(int sampleIntegerArgument = {}, String sampleStringArgument {})",
                sampleIntegerArgument, sampleStringArgument);
        producerService.sendMessage(sampleIntegerArgument, sampleStringArgument);
    }

}
