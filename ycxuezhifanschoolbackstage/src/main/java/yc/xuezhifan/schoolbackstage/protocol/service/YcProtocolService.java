package yc.xuezhifan.schoolbackstage.protocol.service;

import yc.xuezhifan.schoolbackstage.protocol.bean.YcProtocol;


/**
 * <p>
 * Title: YcProtocolService.java
 * </p>
 *
 * <p>
 * Description: 用户协议service
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
public interface YcProtocolService {
    /**
     *根据协议类型查询协议内容
     * @param type
     * @return
     */
    YcProtocol selectProtocolByType(Integer type);
}
