package yc.xuezhifan.schoolbackstage.notification.service.impl;
/**
 * <p>Title: YcSystemNotificationImpl.java </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2018年12月31日</p>
 *
 * @email xiaobai@xuezhifan.com
 * @author xiaobai
 * @date 2018年12月31日
 * @version 1.0
 */

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageInfo;
import yc.xuezhifan.schoolbackstage.notification.bean.YcSystemNotification;
import yc.xuezhifan.schoolbackstage.notification.mapper.YcSystemNotificationMapper;
import yc.xuezhifan.schoolbackstage.notification.service.YcSystemNotificationService;
import yc.xuezhifan.schoolbackstage.utils.Page;


@Service
public class YcSystemNotificationImpl implements YcSystemNotificationService {

    @Autowired
    private YcSystemNotificationMapper ycSystemNotificationMapper;

    @Override
    public Page findAll(Integer currentPage, Integer pageSize) {

//		计算总记录数
        int size = ycSystemNotificationMapper.findAll().size();
//		分页
        PageHelper.startPage(currentPage, pageSize);
        List<YcSystemNotification> ycSystemNotifications = ycSystemNotificationMapper.findAll();
        PageInfo<YcSystemNotification> pageInfo = new PageInfo<>(ycSystemNotifications);
        if (pageInfo != null) {
            return new Page(0, "", size, pageInfo.getList());
        } else {
            return new Page(0, "", size, null);
        }
    }


}
