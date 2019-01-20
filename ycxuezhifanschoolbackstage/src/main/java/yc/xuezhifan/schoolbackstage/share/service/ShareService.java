package yc.xuezhifan.schoolbackstage.share.service;

import yc.xuezhifan.schoolbackstage.share.bean.YcChildInformation;
import yc.xuezhifan.schoolbackstage.share.vo.ShareVo;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;

import java.util.Map;

/**
 *

 * <p>Title: ShareService.java </p>

 * <p>Description: 关注孩子service</p>

 * <p>Copyright: Copyright (c) 2019年1月2日</p>

 * @email xiaoyu@xuezhifan.com

 * @author xiaoyu

 * @date 2019年1月2日

 * @version 1.0
 */
public interface ShareService {

    /*
    通过孩子id获取孩子信息
     */
    YcChildInformation selectChildById(String id);

    /*
    通过用户id查询用户信息
     */
    YcUser selectUserById(String id);
    /*

    /*
    分享关注孩子
     */
    Integer shareChild(ShareVo shareVo);
}
