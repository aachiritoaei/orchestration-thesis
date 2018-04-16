package app.kafka_consumer;

import app.domain.Measurement;
import app.repositories.MeasurementRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    @Autowired
    private MeasurementRepository measurementRepository;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    public CountDownLatch getLatch() {
        return latch;
    }

    @KafkaListener(topics = "${kafka.topic.kafka-io}")
    public void receive(String payload) {
        LOGGER.info("Received devEui ='{}'", payload);

        Measurement measurement = new Measurement(
                payload,
                "kafkaDataType",
                "kafkaRawData",
                "kafkaJsonData");

        measurementRepository.save(measurement);

        latch.countDown();
    }
}