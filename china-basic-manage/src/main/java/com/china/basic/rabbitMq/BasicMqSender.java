package com.china.basic.rabbitMq;

import com.china.common.common.ChinaContant;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * @Description: mq发送类
 * @Author: wuzhenyi
 * @CreateDate: 2023/11/5 20:59	//创建时间
 * @Version: 1.0	//版本号
 */
@Component
public class BasicMqSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendVipPoints(String msg){
        rabbitTemplate.convertAndSend(ChinaContant.VIP_POINTS_EXCHANGE,null,msg);
    }
}
