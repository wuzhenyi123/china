package com.china.basic.config;


import com.china.common.common.ChinaContant;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    @Bean
    public FanoutExchange getVipExchange(){
        return ExchangeBuilder.fanoutExchange(ChinaContant.VIP_POINTS_EXCHANGE).build();
    }

    @Bean
    public Queue getVipQueue(){
        return new Queue(ChinaContant.VIP_POINTS_QUEUE);
    }

    @Bean
    public Binding bindingVipQueue(){
        return BindingBuilder.bind(getVipQueue()).to(getVipExchange());
    }

}
