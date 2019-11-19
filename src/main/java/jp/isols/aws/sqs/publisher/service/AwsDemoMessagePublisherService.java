package jp.isols.aws.sqs.publisher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.amazonaws.services.sqs.model.SendMessageResult;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AwsDemoMessagePublisherService {

    private int i = 0;

    @Autowired
    private AwsDemoSqsClient basicSqsClient;

    @Scheduled(fixedRate = 1000)
    private void sendMessages() {
        SendMessageResult result = basicSqsClient.getBasicSqsClient().sendMessage(basicSqsClient.getSqsUrl(), "Hello " + i);
        log.info("Published Message {}", result.getMessageId());
        i++;
    }
}