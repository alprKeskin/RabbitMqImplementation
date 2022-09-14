package io.github.alprkeskin.consumermicroservice.service.consumer;

import io.github.alprkeskin.consumermicroservice.model.TransferredData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageConsumer {
    /**
     * This method is triggered when producer service send a message.
     * This message includes the transferredData which is passed as an argument to this method.
     * You can do whatever you want with this method.
     * For example, I will print the transferred data.
     * **/
    @RabbitListener(queues = {"#{'producer-to-consumer'.concat('-queue')}"})
    public void rabbitListenerMethod(TransferredData transferredData) {
        log.info("MessageConsumer::rabbitListenerMethod(int transferredData.getSampleIntegerField() = {}, String transferredData.getSampleStringField() {})",
                transferredData.getSampleIntegerField(), transferredData.getSampleStringField());
        System.out.println("transferredData.sampleIntegerField: " + transferredData.getSampleIntegerField());
        System.out.println("transferredData.sampleStringField: " + transferredData.getSampleStringField());
    }
}