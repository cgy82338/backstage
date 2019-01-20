package yc.xuezhifan.schoolbackstage.protocol.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yc.xuezhifan.schoolbackstage.protocol.bean.YcProtocol;
import yc.xuezhifan.schoolbackstage.protocol.mapper.YcProtocolMapper;
import yc.xuezhifan.schoolbackstage.protocol.service.YcProtocolService;


/**
 * <p>
 * Title: YcProtocolServiceImpl.java
 * </p>
 *
 * <p>
 * Description: 用户协议service实现类
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
@Service
public class YcProtocolServiceImpl implements YcProtocolService {

    @Autowired
    YcProtocolMapper ycProtocolMapper;

    /**
     *根据协议类型查询协议内容
     * @param type
     * @return
     */
    @Override
    public YcProtocol selectProtocolByType(Integer type) {
        return ycProtocolMapper.selectProtocolByType(type);
    }
}
