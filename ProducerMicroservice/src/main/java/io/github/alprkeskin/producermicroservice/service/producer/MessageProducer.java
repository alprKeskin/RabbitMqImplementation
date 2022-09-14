package io.github.alprkeskin.producermicroservice.service.producer;

import io.github.alprkeskin.producermicroservice.model.TransferredData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Value("#{'producer-to-consumer'.concat('-exchange')}")
    private String exchangeKey;
    @Value("#{'producer-to-consumer'.concat('-routing')}")
    private String routingKey;

    public void sendMessageToConsumer(final int sampleIntegerArgument, final String sampleStringArgument) {
        log.info("MessageProducer::sendMessageToConsumer(int sampleIntegerArgument = {}, String sampleStringArgument {})",
                sampleIntegerArgument, sampleStringArgument);
        // create the transferred data
        TransferredData transferredData = TransferredData.builder().
                sampleIntegerField(sampleIntegerArgument).
                sampleStringField(sampleStringArgument).build();
        // send the data using rabbit template
        rabbitTemplate.convertAndSend(exchangeKey, routingKey, transferredData);
    }
}
