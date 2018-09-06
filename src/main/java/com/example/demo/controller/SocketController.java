package com.example.demo.controller;

import com.example.demo.socket.MyWebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description:  消息发送类。服务端主动发送
 * @Author: Gentle
 * @date 2018/9/5  19:30
 */
@RestController
public class SocketController {
    @Resource
    MyWebSocket myWebSocket;

    @RequestMapping("many")
    public String helloManyWebSocket(){
        //向所有人发送消息
        myWebSocket.sendMessage("你好~！");

        return "发送成功";
    }

    @RequestMapping("one")
    public String helloOneWebSocket(String sessionId) throws IOException {
        //向某个人发送消息
        myWebSocket.sendMessage(sessionId,"你好~！，单个用户");

        return "发送成功";
    }


}