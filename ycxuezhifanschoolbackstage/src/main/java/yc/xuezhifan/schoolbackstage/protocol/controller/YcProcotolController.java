package yc.xuezhifan.schoolbackstage.protocol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.protocol.bean.YcProtocol;
import yc.xuezhifan.schoolbackstage.protocol.service.YcProtocolService;
/**
 * <p>
 * Title: YcProcotolController.java
 * </p>
 *
 * <p>
 * Description: 用户协议controller
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2019年1月11日
 * </p>
 *
 * @email xiaoyu@xuezhifan.com
 *
 * @author xiaoyu
 *
 * @date 2019年1月11日
 *
 * @version 1.0
 */
@Controller
@RequestMapping("/procotol")
public class YcProcotolController {

    @Autowired
    YcProtocolService ycProtocolService;

    /**
     *根据协议类型查询协议内容
     * @param type
     * @return
     */
    @RequestMapping("/show")
    @ResponseBody
    public String selectProtocolByType(Integer type){//1用户协议2支付协议3投诉协议
        YcProtocol p = ycProtocolService.selectProtocolByType(type);
       if (p != null && p.getYc_delete() != 2){
           return p.getYc_protocol_content();
       }{
           return "<h2 align='center'>暂无内容</h2>";
        }

    }
}
