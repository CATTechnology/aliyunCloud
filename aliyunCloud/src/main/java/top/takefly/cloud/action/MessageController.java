package top.takefly.cloud.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @program: aliyunCloud
 * @description: 用于消息类的控制器
 * @author: 戴灵飞
 * @create: 2019-06-29 08:26
 **/
@RestController
public class MessageController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @RequestMapping("/send")
    public void message() {
        Map map = new HashMap();
        map.put("phoneNum" , "15886449241");
        map.put("signName" , "带你飞");
        map.put("templateCode" , "SMS_168592468");
        map.put("templateParam" , "{\"number\":\""+genRn()+"\"}");
        jmsMessagingTemplate.convertAndSend("sendRegisterCode", map);
    }

    /**
     * 生成随机数
     * @return
     */
    public String genRn() {
        Random r = new Random();
        String rn = "";
        for(int i=0;i<6;i++){
            rn+=r.nextInt(10);
        }

        return rn;
    }

}
