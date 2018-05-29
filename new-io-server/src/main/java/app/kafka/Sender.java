package app.kafka;

import app.domain.Measurement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;


public class Sender {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Value("${kafka.topic.kafka-io}")
    private String jsonTopic;

    @Autowired
    private KafkaTemplate<String, Measurement> kafkaTemplate;

    public void send(Measurement measurement) {
        LOGGER.info("sending payload='{}' to topic='{}'", measurement.toString());
        kafkaTemplate.send(jsonTopic, measurement);
    }
}
