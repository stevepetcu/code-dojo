package codedojo.kata.testngakkatddconsumer.diamond;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;

import java.util.Properties;
import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        Properties configuration = new Properties();

        configuration.put(StreamsConfig.APPLICATION_ID_CONFIG, "streams-diamond");
        configuration.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configuration.put(StreamsConfig.CACHE_MAX_BYTES_BUFFERING_CONFIG, 0);
        configuration.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        configuration.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        configuration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        StreamsBuilder builder = new StreamsBuilder();

        KStream<String, String> source = builder.stream("streams-plaintext-input");
        
        source.to("streams-diamond-output");

        final KafkaStreams streams = new KafkaStreams(builder.build(), configuration);
        final CountDownLatch latch = new CountDownLatch(1);

        Runtime.getRuntime().addShutdownHook(new Thread("diamond-shutdown-hook") {
            @Override
            public void run() {
                streams.close();
                latch.countDown();
            }
        });

        try {
            streams.start();
            latch.await();
        } catch (Throwable e) {
            System.exit(1);
        }

        System.exit(0);
    }
}
