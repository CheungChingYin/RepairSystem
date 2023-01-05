package com.repairsystem.config;

import com.repairsystem.utils.ConstantUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * WebSocket 配置类
 *
 * @Author 张正贤
 * @Date 2022/12/10 10:26
 * @Version 1.0
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketStompConfig implements WebSocketMessageBrokerConfigurer {
    /**
     * 配置消息代理(message broker)
     *
     * @param registry 注册对象
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {

        //客户端订阅消息的请求前缀，topic一般用于广播推送，queue用于点对点推送
        registry.enableSimpleBroker(ConstantUtils.WebSocket.BROADCAST_PREFIX, ConstantUtils.WebSocket.PEER_TO_PEER_PREFIX);
        //服务端通知客户端的前缀
        registry.setUserDestinationPrefix("/ws");
    }

    /**
     * 设置切点以及允许http和https的方式建立webSocket
     *
     * @param registry 注册对象
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("endpointOne")
                .setAllowedOrigins("*").withSockJS();
    }
}
