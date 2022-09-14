package io.github.alprkeskin.producermicroservice.service;

import io.github.alprkeskin.producermicroservice.service.producer.MessageProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProducerService {

    @Autowired
    private MessageProducer messageProducer;

    public void sendMessage(final int sampleIntegerArgument, final String sampleStringArgument) {
        log.info("ProducerService::sendMessage(int sampleIntegerArgument = {}, String sampleStringArgument {})",
                sampleIntegerArgument, sampleStringArgument);
        messageProducer.sendMessageToConsumer(sampleIntegerArgument, sampleStringArgument);
    }

}
