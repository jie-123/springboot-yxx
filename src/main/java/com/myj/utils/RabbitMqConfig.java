package com.myj.utils;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
//读取自定义配置文件默认会读取application.properties
@PropertySource({"classpath:/application.properties","classpath:/mqconfig.properties"})
public class RabbitMqConfig  {


    @Value("${mqconfig.importExchange}")
    private String importExchange;

    @Value("${mqconfig.bjjQueue}")
    private String bjjQueue;

    @Value("${mqconfig.zzjQueue}")
    private String zzjQueue;

    @Value("${mqconfig.bjjRoutingKey}")
    private String bjjRoutingKey;

    @Value("${mqconfig.zzjRoutingKey}")
    private String zzjRoutingKey;


    public String getImportExchange(){
        return importExchange;
    }

    public String getBjjRoutingKey(){
        return bjjRoutingKey;
    }

    public String getBjjQueue(){
        return bjjQueue;
    }

    public String getZzjQueue(){
        return zzjQueue;
    }

    /**
     * 创建北京局的队列
     * @return
     */
    @Bean
    public Queue bjjDirectQueue(){
        return new Queue(bjjQueue,true,false,false);
    }

    /**
     * 创建郑州局的队列
     * @return
     */
    @Bean
    public Queue zzjDirectQueue(){
        return new Queue(zzjQueue,true,false,false);
    }

    /**
     * 创建直连交换机
     * @return
     */
    @Bean
     DirectExchange directExchange(){
        return new DirectExchange(importExchange,true,false);
    }



    /**
     * 将交换机和队列进行绑定
     * @return
     */
    @Bean
     Binding bindingImportUpload(){
        return BindingBuilder.bind(bjjDirectQueue()).to(directExchange()).with(bjjRoutingKey);
    }
}
