package yc.xuezhifan.schoolbackstage.protocol.mapper;

import org.apache.ibatis.annotations.Mapper;
import yc.xuezhifan.schoolbackstage.protocol.bean.YcProtocol;

/**
 * @author xiaoyu
 * @version 创建时间：2019年1月11日
 * 用户协议
 */
@Mapper
public interface YcProtocolMapper {
    /**
     * 根据协议类型查询协议内容
     * @param tpye
     * @return
     */
    YcProtocol selectProtocolByType(Integer tpye);
}
