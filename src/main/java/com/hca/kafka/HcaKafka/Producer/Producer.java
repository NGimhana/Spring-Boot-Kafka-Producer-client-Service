package com.hca.kafka.HcaKafka.Producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Properties;

@RestController
@RequestMapping("/kafka")
public class Producer {


//    @RequestMapping(value = "/publish" , method = RequestMethod.POST)
//    public void sendMessage(@RequestBody String message) throws Exception{
//
//
//        Properties properties = new Properties();
//        properties.put("bootstrap.servers", "localhost:9092");
//        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//
//
//        KafkaProducer kafkaProducer = new KafkaProducer(properties);
//        try{
//            kafkaProducer.send(new ProducerRecord("Test123", message));
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            kafkaProducer.close();
//        }
//
//
//
//    }


    @RequestMapping(value = "/publish/{message}" , method = RequestMethod.GET , produces = "application/json")
    public Shop sendMessage(@PathVariable("message") String message) throws Exception{


        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);


        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        try{
            kafkaProducer.send(new ProducerRecord("Test123", message));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            kafkaProducer.close();
        }


        Shop s =new Shop();
        s.setName(message);
        return s;
    }

}