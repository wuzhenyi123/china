package com.china.basic.rabbitMq;

import com.china.common.common.ChinaContant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * @Description: 基础数据mq监听
 * @Author: wuzhenyi
 * @CreateDate: 2023/11/5 21:02	//创建时间
 * @Version: 1.0	//版本号
 */
@Slf4j
@Component
public class BasicMqLinstener {

    @RabbitListener(queues = ChinaContant.VIP_POINTS_QUEUE)
    public void listenMessage(String message) {
        log.info("#####监听会员积分变更通知#####通知内容：{}",message);
    }
}
