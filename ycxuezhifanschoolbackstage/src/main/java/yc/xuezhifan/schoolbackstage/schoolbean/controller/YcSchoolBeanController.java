package yc.xuezhifan.schoolbackstage.schoolbean.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * <p>Title: YcSchoolBean.java </p>
 * <p>Description:学校的智慧豆记录 </p>
 * <p>Copyright: Copyright (c) 2018年11月5日</p>
 * @email xiaoke@xuezhifan.com

 * @author xiaoke

 * @date 2018年11月5日

 * @version 1.0
 */
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;

import yc.xuezhifan.schoolbackstage.annotation.CurrentSchool;
import yc.xuezhifan.schoolbackstage.annotation.SchoolLogin;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.constants.YcSchoolBeanConstants;
import yc.xuezhifan.schoolbackstage.school.bean.YcSchool;
import yc.xuezhifan.schoolbackstage.school.service.YcSchoolService;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcOrder;
import yc.xuezhifan.schoolbackstage.schoolbean.bean.YcSchoolBean;
import yc.xuezhifan.schoolbackstage.schoolbean.mapper.YcSchoolBeanMapper;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcOrderService;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcSchoolBeanRecordService;
import yc.xuezhifan.schoolbackstage.schoolbean.service.YcSchoolBeanService;
import yc.xuezhifan.schoolbackstage.utils.Page;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;
import yc.xuezhifan.schoolbackstage.utils.UUIDFactory;

@Controller
@RequestMapping("/schoolbean")
public class YcSchoolBeanController {

    @Autowired
    private YcSchoolService ycSchoolService;

    @Autowired
    private YcOrderService ycOrderService;

    @Autowired
    private YcSchoolBeanService ycSchoolBeanService;

    @Autowired
    private YcSchoolBeanRecordService ycSchoolBeanRecordService;
    /**
     * <p>Title: schoolWallet</p>
     *
     * <p>Description: 获取学校智慧豆</p>
     *
     * @param ycSchool    当前登录学校
     * @param currentPage 当前页
     * @param pageSize    每页显示的数目
     * @param startTime   开始时间 yyyy-mm-dd
     * @param endTime     结束时间 yyyy-mm-dd
     * @param model
     * @return
     * @email xiaoke@xuezhifan.com
     * @author xiaoke
     * @date 2018年11月5日
     */
    public ModelAndView schoolWallet(@CurrentSchool YcSchool ycSchool,
                                     @RequestParam(defaultValue = "1") Integer currentPage, @RequestParam(defaultValue = "2") Integer pageSize,
                                     String startTime, String endTime, Model model) {
        if (RegexUtil.isNull(ycSchool)) {
            return new ModelAndView("/toLogin");
        }
        try {
            YcSchool school = ycSchoolService.findBySchoolId(ycSchool.getId());
            PageInfo<YcOrder> ycOrders = ycOrderService.findBySchoolId(ycSchool.getId(), currentPage, pageSize, startTime, endTime);
            model.addAttribute("school", school);
            model.addAttribute("ycOrders", ycOrders);
            return new ModelAndView("/");
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", YcSchoolBeanConstants.FAILURE);
            return new ModelAndView("/error");
        }
    }

    /**
     * 开通推广功能
     */
    @RequestMapping("/isWisdom")
    @ResponseBody
    @SchoolLogin
    public JacksonData isWisdom(@CurrentSchool YcSchool ycSchool) {
//		查询学校智慧豆的总额
        YcSchoolBean wisdom = ycSchoolBeanService.findBeanBySchoolId(ycSchool.getId());
//		判断智慧豆是否足够1000开通
        if (wisdom.getYc_wisdom_beans() >= 1000) {

            Double wisbean = wisdom.getYc_wisdom_beans() - 1000;
            wisdom.setYc_wisdom_beans(wisbean);
            //		更新学校智慧豆余额
            ycSchoolBeanService.modifyBeans(wisdom);
//            生成订单
            ycOrderService.save(ycSchool);
//            更新学校资金变化记录
            ycSchoolBeanRecordService.saveYcWisdomBeanRecord(6,1000d,'-',wisbean,"",ycSchool.getId());
//            学校功能表状态表添加

            return ResultUtil.success();
        } else {
            return ResultUtil.error(204, YcSchoolBeanConstants.LESS_BEAN);
        }
    }
}
