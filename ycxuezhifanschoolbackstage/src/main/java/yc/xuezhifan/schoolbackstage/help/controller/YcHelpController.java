package yc.xuezhifan.schoolbackstage.help.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import yc.xuezhifan.schoolbackstage.bean.JacksonData;
import yc.xuezhifan.schoolbackstage.help.bean.YcHelp;
import yc.xuezhifan.schoolbackstage.help.service.YcHelpService;
import yc.xuezhifan.schoolbackstage.utils.RegexUtil;
import yc.xuezhifan.schoolbackstage.utils.ResultUtil;

import java.util.List;

/**
 * <p>
 * Title: YcHelpController.java
 * </p>
 *
 * <p>
 * Description: 使用帮助controller
 * </p>
 *
 * <p>
 * Copyright: Copyright (c) 2019年1月11日
 * </p>
 *
 * @author xiaoyu
 * @version 1.0
 * @email xiaoyu@xuezhifan.com
 * @date 2019年1月11日
 */
@Controller
@RequestMapping("/help")
public class YcHelpController {

    @Autowired
    YcHelpService ycHelpService;

    /**
     * 查询所有帮助
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/findAll", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public JacksonData<YcHelp> findAll() {
        List<YcHelp> findAll = ycHelpService.findAll();
        if (RegexUtil.isNotNull(findAll)) {
            return ResultUtil.success(findAll);
        }
        return ResultUtil.error(201, "暂无数据");
    }

    /**
     * 根据名称查询使用帮助内容
     *
     * @return
     */
    @RequestMapping("/show")
    @ResponseBody
    public String selectHelpByName(String name) {
        YcHelp help = ycHelpService.selectHelpByName(name);
        if (help != null) {
            return help.getYc_help_details();
        } else {
            return "<h2 align='center'>暂无内容</h2>";
        }
    }
}
