package yc.xuezhifan.schoolbackstage.schoolnotice.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import yc.xuezhifan.schoolbackstage.advertising.bean.YcPushAd;
import yc.xuezhifan.schoolbackstage.advertising.service.IYcPushAdService;
import yc.xuezhifan.schoolbackstage.constants.NoticeConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.schoolnotice.bean.YcNoticeSchool;
import yc.xuezhifan.schoolbackstage.schoolnotice.mapper.YcNoticeSchoolMapper;
import yc.xuezhifan.schoolbackstage.schoolnotice.service.YcNoticeSchoolService;
import yc.xuezhifan.schoolbackstage.user.bean.YcUser;
import yc.xuezhifan.schoolbackstage.user.mapper.YcUserMapper;
import yc.xuezhifan.schoolbackstage.utils.JpushClientUtil;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

/**
 * <p>Title: YcNoticeSchoolServiceImpl.java </p>
 *
 * <p>Description: 学校通知公告</p>
 *
 * <p>Copyright: Copyright (c) 2018年10月2日</p>
 *
 * @author xiaoxiao
 * @version 1.0
 * @email xiaoxiao@xuezhifan.com
 * @date 2018年10月2日
 */
@Service
public class YcNoticeSchoolServiceImpl implements YcNoticeSchoolService {

    @Autowired
    YcNoticeSchoolMapper ycNoticeSchoolMapper;

    @Autowired
    IYcPushAdService iYcPushAdService;

    @Autowired
    YcUserMapper ycUserMapper;

    @Override
    @Transactional
    public String insert(YcNoticeSchool ycNoticeSchool, YcSchool ycSchool) {
        //得到地区广告
        YcPushAd ycPushAd = iYcPushAdService.selectBydistrict(ycSchool.getYc_district());
        Integer advertising_people = ycPushAd == null ? null : ycPushAd.getYc_advertising_people();

        //通知表数据集合
        List<YcNoticeSchool> NoticeSchool = new ArrayList<YcNoticeSchool>();
        NoticeSchool.add(ycNoticeSchool);
        System.out.println(ycNoticeSchool.getYc_notice_detail().length());
        System.out.println(ycNoticeSchool.getYc_notice_detail());

        try {
            //补全YcNoticeSchool剩余属性
            ycNoticeSchool.setId(UUIDFactory.random());//id
            ycNoticeSchool.setYc_notice_school(ycSchool.getId());//学校id
            ycNoticeSchool.setYc_notice_id(ycUserMapper.selectByPhone(ycSchool.getYc_school_principal_phone()).getId());//发布人id
            ycNoticeSchool.setYc_notice_time(new Date());//发布时间
            ycNoticeSchool.setYc_notice_voice("");
            //把通知添加到学校通知表中
            Integer insert = ycNoticeSchoolMapper.insert(NoticeSchool);

            List<String> list = ycUserMapper.selectTokenAll();
            int sum = -1;
            String[] tokensAll = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                if (StringUtils.isNotBlank(list.get(i))) {
                    sum += 1;
                    tokensAll[sum] = list.get(i);
                }

            }
            String[] tokens = new String[sum];
            for (int i = 0; i <tokens.length ; i++) {
                tokens[i] = tokensAll[i];
            }
            int results = 0;
            if (RegexUtil.isNotNull(ycPushAd)) {
                // 调用激光推送 极光推送成功
                results = JpushClientUtil.sendToMultipleUsers(tokens,ycPushAd.getYc_headline() + "提醒您" + ycNoticeSchool.getYc_notice_detail(), "", ycNoticeSchool.getYc_notice_image(), ycNoticeSchool.getYc_notice_voice());
            } else {
                results = JpushClientUtil.sendToMultipleUsers(tokens,"学知帆提醒您", ycNoticeSchool.getYc_notice_detail(), ycNoticeSchool.getYc_notice_image(), ycNoticeSchool.getYc_notice_voice());
            }

            if (0 < results && RegexUtil.isNotNull(insert)) {
                return NoticeConstants.SUCCESS;
            } else {
                return NoticeConstants.FAILURE;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return NoticeConstants.FAILURE;
        }
    }

    @Override
    public List<YcNoticeSchool> findAll(Integer currentPage, Integer pageSize) {
        return ycNoticeSchoolMapper.findAll(currentPage, pageSize);
    }

    @Override
    public Page noticeSchoolById(String id, Integer currentPage, Integer pageSize) {
//		计算总记录数
        int size = ycNoticeSchoolMapper.noticeSchoolById(id).size();
//		分页
        PageHelper.startPage(currentPage, pageSize);
        List<YcNoticeSchool> ycNoticeSchools = ycNoticeSchoolMapper.noticeSchoolById(id);
        PageInfo<YcNoticeSchool> pageInfo = new PageInfo<>(ycNoticeSchools);
        if (pageInfo != null){
            return new Page(0, "", size, pageInfo.getList());
        }else {
            return new Page(0, "", size, null);
        }

    }

    @Override
    public List<String> selectByUserToken(String yc_notice_class, Integer advertising_people) {
        List<String> token = ycNoticeSchoolMapper.selectByUserToken(yc_notice_class, advertising_people);
        return token;
    }

    @Override
    public List<YcNoticeSchool> noticeSchoolByUserId(String yc_notice_school) {
        List<YcNoticeSchool> userId = ycNoticeSchoolMapper.noticeSchoolByUserId(yc_notice_school);
        return userId;
    }


}
