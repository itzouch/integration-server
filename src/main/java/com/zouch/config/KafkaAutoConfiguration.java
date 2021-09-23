//package com.zouch.config;
//
//import org.apache.kafka.common.serialization.StringSerializer;
//import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
//import org.springframework.boot.autoconfigure.kafka.StreamsBuilderFactoryBeanCustomizer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.util.CollectionUtils;
//
//import java.util.Collections;
//import java.util.Properties;
//import java.util.function.Supplier;
//import java.util.stream.Collectors;
//
///**
// * @author ZouQi
// * @date 2021/9/22 下午5:38
// */
//@Configuration
//public class KafkaAutoConfiguration {
//
//    @Bean
//    @Primary
//    public StreamsBuilderFactoryBeanCustomizer kafkaConfig() {
//        return factoryBean -> {
//            factoryBean.setSingleton(true);
//            factoryBean.setStreamsConfiguration();
//
//        };
//    }
//    @Bean
//    public DefaultKafkaProducerFactoryCustomizer producerFactoryCustomizer(){
//        return producerFactory->{
//            producerFactory.setBootstrapServersSupplier(() -> "localhost");
//            producerFactory.setKeySerializer(new StringSerializer().var);
//        };
//    }
//
//    private Properties getFactoryConfig(){
//        Properties properties = new Properties();
//        properties.put()
//    }
//
//
//}
